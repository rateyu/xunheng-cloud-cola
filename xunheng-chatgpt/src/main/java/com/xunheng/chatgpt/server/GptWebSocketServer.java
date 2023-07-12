package com.xunheng.chatgpt.server;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.unfbx.chatgpt.OpenAiStreamClient;
import com.unfbx.chatgpt.entity.chat.ChatCompletion;
import com.unfbx.chatgpt.entity.chat.Message;
import com.xunheng.chatgpt.cache.LocalCache;
import com.xunheng.chatgpt.listener.OpenAIWebSocketEventSourceListener;
import com.xunheng.redis.util.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.TimeUnit;

/**
 * 描述：websocket 服务端
 *
 * @author https:www.unfbx.com
 * @date 2023-03-23
 */
@Slf4j
@Component
@ServerEndpoint("/websocket/{token}")
public class GptWebSocketServer {

    private static OpenAiStreamClient openAiStreamClient;

    private static RedisUtil redisUtil;

    @Autowired
    public void setGptWebSocketServer(OpenAiStreamClient openAiStreamClient,RedisUtil redisUtil) {
        this.openAiStreamClient = openAiStreamClient;
        this.redisUtil = redisUtil;
    }

    //在线总数
    private static int onlineCount;
    //当前会话
    private Session session;
    //用户登陆的sa token
    private String token;

    private static CopyOnWriteArraySet<GptWebSocketServer> webSocketSet = new CopyOnWriteArraySet<>();

    /**
     * 用来存放每个客户端对应的WebSocketServer对象
     */
    private static ConcurrentHashMap<String, GptWebSocketServer> webSocketMap = new ConcurrentHashMap();

    /**
     * 为了保存在线用户信息，在方法中新建一个list存储一下【实际项目依据复杂度，可以存储到数据库或者缓存】
     * 由于chagpt对话是单对单的 不涉及到群发多发 未做会话集群处理
     */
    private final static List<Session> SESSIONS = Collections.synchronizedList(new ArrayList<>());


    /**
     * 建立连接
     * @param session
     * @param token
     */
    @OnOpen
    public void onOpen(Session session, @PathParam("token") String token) {
        this.session = session;
        this.token = token;
        webSocketSet.add(this);
        SESSIONS.add(session);
        if (webSocketMap.containsKey(token)) {
            webSocketMap.remove(token);
            webSocketMap.put(token, this);
        } else {
            webSocketMap.put(token, this);
            addOnlineCount();
        }
        log.info("[连接ID:{}] 建立连接, 当前连接数:{}", this.token, getOnlineCount());
    }

    /**
     * 断开连接
     */
    @OnClose
    public void onClose() {
        webSocketSet.remove(this);
        if (webSocketMap.containsKey(token)) {
            webSocketMap.remove(token);
            subOnlineCount();
        }
        log.info("[连接ID:{}] 断开连接, 当前连接数:{}", token, getOnlineCount());
    }

    /**
     * 发送错误
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error) {
        log.info("[连接ID:{}] 错误原因:{}", this.token, error.getMessage());
        error.printStackTrace();
    }

    /**
     * 接收到客户端消息
     * @param msg
     */
    @OnMessage
    public void onMessage(String msg) {
        log.info("[连接ID:{}] 收到消息:{}", this.token, msg);
        //如果发送的消息 是约定好的格式 分别处理 【停止输出】 与 【关闭链接】
        if(msg.contains("[gpt:msg:stop]")){//【停止输出】
            String[] msgs = msg.split("&split&");
            setStopCompletionIds(msgs[1]);
            return;
        }else if(StringUtils.equals(msg,"[gpt:msg:end]")){//【关闭链接】
            this.onClose();
            return;
        }
        //接受参数
        OpenAIWebSocketEventSourceListener eventSourceListener = new OpenAIWebSocketEventSourceListener(this.session);
        String messageContext = redisUtil.get("gptMessageContext:"+token);
        List<Message> messages = new ArrayList<>();
        //上下文只存储10条消息
        if (StrUtil.isNotBlank(messageContext)) {
            messages = JSONUtil.toList(messageContext, Message.class);
            if (messages.size() >= 10) {
                messages = messages.subList(1, 10);
            }
        }
        Message currentMessage = Message.builder().content(msg).role(Message.Role.USER).build();
        messages.add(currentMessage);
        openAiStreamClient.streamChatCompletion(messages, eventSourceListener);
        //更新缓存的消息记录 此处应该设置一个过期的时间 这里设置为30分钟
        redisUtil.set("gptMessageContext:"+token, JSONUtil.toJsonStr(messages),30L,TimeUnit.MINUTES);
    }

    private void setStopCompletionIds(String id){
        List<String> stopCompletionIds = new ArrayList<>();
        Object obj = LocalCache.CACHE.get("stopCompletionId");
        if(obj != null){
            stopCompletionIds = (List<String>) obj;
        }
        stopCompletionIds.add(id);
        LocalCache.CACHE.put("stopCompletionId",stopCompletionIds);
    }


    /**
     * 获取当前连接数
     *
     * @return
     */
    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    /**
     * 当前连接数加一
     */
    public static synchronized void addOnlineCount() {
        GptWebSocketServer.onlineCount++;
    }

    /**
     * 当前连接数减一
     */
    public static synchronized void subOnlineCount() {
        GptWebSocketServer.onlineCount--;
    }

}

