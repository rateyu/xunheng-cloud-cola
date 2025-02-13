package com.xunheng.chatgpt.listener;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.unfbx.chatgpt.entity.chat.ChatCompletionResponse;
import com.xunheng.chatgpt.cache.LocalCache;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.sse.EventSource;
import okhttp3.sse.EventSourceListener;

import jakarta.websocket.Session;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 描述：OpenAI流式输出Socket接收
 *
 * @author https:www.unfbx.com
 * @date 2023-03-23
 */
@Slf4j
public class OpenAIWebSocketEventSourceListener extends EventSourceListener {

    private Session session;

    public OpenAIWebSocketEventSourceListener(Session session) {
        this.session = session;
    }




    /**
     * {@inheritDoc}
     */
    @Override
    public void onOpen(EventSource eventSource, Response response) {
        log.info("OpenAI建立sse连接...");
    }

    /**
     * {@inheritDoc}
     */
    @SneakyThrows
    @Override
    public void onEvent(EventSource eventSource, String id, String type, String data) {
        log.info("OpenAI返回数据：{}", data);
        if (data.equals("[DONE]")) {
            log.info("OpenAI返回数据结束了");
            session.getBasicRemote().sendText("[DONE]");
            return;
        }
        ObjectMapper mapper = new ObjectMapper();
        ChatCompletionResponse completionResponse = mapper.readValue(data, ChatCompletionResponse.class); // 读取Json
        String completionId = completionResponse.getId();
        if(getStopCompletionIds().contains(completionId))return;
        String delta = mapper.writeValueAsString(completionResponse.getChoices().get(0).getDelta());
        JSONObject result = new JSONObject();
        try {
            result = JSONObject.parseObject(delta);
        }catch (Exception e){
           log.info("delta结果转换失败");
        }
        result.put("completionId",completionId);
        session.getBasicRemote().sendText(result.toJSONString());
    }

    private List<String> getStopCompletionIds(){
        List<String> stopCompletionIds = new ArrayList<>();
        Object obj = LocalCache.CACHE.get("stopCompletionId");
        if(obj != null){
            stopCompletionIds = (List<String>) obj;
        }
        return stopCompletionIds;
    }


    @Override
    public void onClosed(EventSource eventSource) {
        log.info("OpenAI关闭sse连接...");
    }


    @SneakyThrows
    @Override
    public void onFailure(EventSource eventSource, Throwable t, Response response) {
        if (Objects.isNull(response)) {
            return;
        }
        ResponseBody body = response.body();
        if (Objects.nonNull(body)) {
            log.error("OpenAI  sse连接异常data：{}，异常：{}", body.string(), t);
        } else {
            log.error("OpenAI  sse连接异常data：{}，异常：{}", response, t);
        }
        eventSource.cancel();
    }

}
