package com.lwl.websocket.config;

import com.alibaba.fastjson.serializer.SerializeConfig;
import com.lwl.websocket.component.LongToStringCodec;
import com.lwl.websocket.handler.TestSocketHandler;
import com.lwl.websocket.interceptor.LoginHandshakeInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.server.standard.ServletServerContainerFactoryBean;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * @author wangjiawei
 * @date 2020/5/12
 **/
@Configuration
public class WSConfig implements WebSocketConfigurer {
    private static final int MAX_MESSAGE_SIZE = 1024 * 32 * 100;
    private static final long MAX_IDLE = 1000 * 10;

    @Resource
    private LoginHandshakeInterceptor loginHandshakeInterceptor;
    @Resource
    private TestSocketHandler testSocketHandler;

    @PostConstruct
    public void otherConfig(){
        SerializeConfig serializeConfig = SerializeConfig.getGlobalInstance();
        //TODO 干嘛的来着
        serializeConfig.put(Long.TYPE, LongToStringCodec.getInstance());
        serializeConfig.put(Long.class, LongToStringCodec.getInstance());
    }

    @Bean
    public ServletServerContainerFactoryBean createWebSocketContainer() {
        ServletServerContainerFactoryBean container = new ServletServerContainerFactoryBean();
        //TODO 干嘛的来着
        container.setMaxTextMessageBufferSize(MAX_MESSAGE_SIZE);
        container.setMaxBinaryMessageBufferSize(MAX_MESSAGE_SIZE);
        container.setMaxSessionIdleTimeout(MAX_IDLE);
        return container;
    }

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        //访问 ws://host:port/ws   就会进入  loginHandshakeInterceptor   -> testSocketHandler
        registry.addHandler(testSocketHandler, "/ws")
                .setAllowedOrigins("*")
                .addInterceptors(loginHandshakeInterceptor);
        //旧版浏览器可能不支持 websocket，通过 sockjs 模拟 websocket 的行为，所以下面要配 sockjs 支持。
        registry.addHandler(testSocketHandler, "/sockjs").setAllowedOrigins("*")
                .addInterceptors(loginHandshakeInterceptor).withSockJS();
    }
}