package com.xunheng.websocket.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * @program: xunheng-cloud-cola
 * @description: websocket配置
 * @author: hhqkkr
 * @date: 2023/7/12 13:53
 */
@Configuration
public class WebSocketConfig {

    /**
     * 这个bean的注册,用于扫描带有@ServerEndpoint的注解成为websocket,如果你使用外置的tomcat就不需要该配置文件
     */
    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }
}
