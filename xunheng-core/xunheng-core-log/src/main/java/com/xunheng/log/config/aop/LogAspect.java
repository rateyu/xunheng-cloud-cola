package com.xunheng.log.config.aop;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.spring.PropertyPreFilters;
import com.xunheng.base.enums.BusinessStatus;
import com.xunheng.base.utils.IpUtils;
import com.xunheng.base.utils.ServletUtils;
import com.xunheng.log.client.dto.LogCreateCmd;
import com.xunheng.log.config.annotation.Log;
import com.xunheng.log.app.executor.AsyncLogSaveCmdExe;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collection;
import java.util.Map;

/**
 * @program: xunheng-cloud-cola
 * @description: 日志切面处理
 * @author: hhqkkr
 * @date: 2023/6/29 17:14
 */
@Slf4j
@Aspect
@Component
public class LogAspect
{

    @Resource
    private AsyncLogSaveCmdExe asyncLogSaveCmdExe;

    /**
     * 处理完请求后执行
     * @param joinPoint 切点
     */
    @AfterReturning(pointcut = "@annotation(controllerLog)", returning = "result")
    public void doAfterReturning(JoinPoint joinPoint, Log controllerLog, Object result){
        handleLog(joinPoint, controllerLog, null, result);
    }

    /**
     * 拦截异常操作
     * @param joinPoint 切点
     * @param e 异常
     */
    @AfterThrowing(value = "@annotation(controllerLog)", throwing = "e")
    public void doAfterThrowing(JoinPoint joinPoint, Log controllerLog, Exception e){
        handleLog(joinPoint, controllerLog, e, null);
    }

    protected void handleLog(final JoinPoint joinPoint, Log controllerLog, final Exception e, Object result){
        try{
            // *========组装日志=========*//
            LogCreateCmd operLog = new LogCreateCmd();
            operLog.setStatus(BusinessStatus.SUCCESS.ordinal());
            // 请求的地址
            String ip = IpUtils.getIpAddr(ServletUtils.getRequest());
            operLog.setOperIp(ip);
            operLog.setOperUrl(ServletUtils.getRequest().getRequestURI());
            if (e != null){//是异常返回
                operLog.setStatus(BusinessStatus.FAIL.ordinal());
                operLog.setErrorMsg(StrUtil.sub(e.getMessage(), 0, 2000));
            }
            // 设置方法名称
            String className = joinPoint.getTarget().getClass().getName();
            String methodName = joinPoint.getSignature().getName();
            operLog.setMethod(className + "." + methodName + "()");
            // 设置请求方式
            operLog.setRequestMethod(ServletUtils.getRequest().getMethod());
            // 处理设置注解上的参数
            getControllerMethodDescription(joinPoint, controllerLog, operLog, result);
            // 保存数据库
            asyncLogSaveCmdExe.execute(operLog);
        }catch (Exception exp){
            //记录本地异常日志
            log.error("==前置通知异常==");
            log.error("异常信息:{}", exp.getMessage());
            exp.printStackTrace();
        }
    }

    /**
     * 获取注解中对方法的描述信息 用于Controller层注解
     * @param log 日志
     * @param esLog 操作日志
     */
    public void getControllerMethodDescription(JoinPoint joinPoint, Log log, LogCreateCmd esLog, Object result){
        // 设置action动作
        esLog.setBusinessType(log.businessType().name());
        // 设置标题
        esLog.setModule(log.module());
        // 设置功能详情
        esLog.setTitle(log.title());
        // 是否需要保存request，参数和值
        if (log.isSaveRequestData()) {
            // 获取参数的信息
            setRequestValue(joinPoint, esLog);
        }
        // 是否需要保存response，参数和值
        if (log.isSaveResponseData() && result != null){
            esLog.setResultStr(StrUtil.sub(JSON.toJSONString(result), 0, 2000));
        }
    }

    /**
     * 获取请求的参数，放到log中
     * @param operLog 操作日志
     */
    private void setRequestValue(JoinPoint joinPoint, LogCreateCmd operLog){
        String requestMethod = operLog.getRequestMethod();
        if (HttpMethod.PUT.name().equals(requestMethod) || HttpMethod.POST.name().equals(requestMethod)){
            String params = argsArrayToString(joinPoint.getArgs());
            operLog.setOperParam(StrUtil.sub(params, 0, 2000));
        }
    }

    /**
     * 参数拼装
     */
    private String argsArrayToString(Object[] paramsArray){
        StringBuilder params = new StringBuilder();
        if (paramsArray != null){
            for (Object o : paramsArray){
                if (o != null && !isFilterObject(o)){
                    String[] excludeProperties = {"file"};//排除掉file
                    PropertyPreFilters filters = new PropertyPreFilters();
                    PropertyPreFilters.MySimplePropertyPreFilter excludefilter = filters.addFilter();
                    // 指定排除属性过滤器：转换成JSON字符串时，排除哪些属性
                    excludefilter.addExcludes(excludeProperties);
                    String paramJsonString = JSONObject.toJSONString(o, excludefilter, SerializerFeature.PrettyFormat);
                    params.append(paramJsonString).append(" ");
                }
            }
        }
        return params.toString().trim();
    }

    /**
     * 判断是否需要过滤的对象。
     * @param o 对象信息。
     * @return 如果是需要过滤的对象，则返回true；否则返回false。
     */
    @SuppressWarnings("rawtypes")
    public boolean isFilterObject(final Object o){
        Class<?> clazz = o.getClass();
        if (clazz.isArray()) {
            return clazz.getComponentType().isAssignableFrom(MultipartFile.class);
        }else if (Collection.class.isAssignableFrom(clazz)){
            Collection collection = (Collection) o;
            for (Object value : collection){
                return value instanceof MultipartFile;
            }
        }else if (Map.class.isAssignableFrom(clazz)) {
            Map map = (Map) o;
            for (Object value : map.entrySet()){
                Map.Entry entry = (Map.Entry) value;
                return entry.getValue() instanceof MultipartFile;
            }
        }
        return o instanceof MultipartFile || o instanceof HttpServletRequest || o instanceof HttpServletResponse
                || o instanceof BindingResult;
    }
}
