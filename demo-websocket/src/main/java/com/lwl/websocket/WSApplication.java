package com.lwl.websocket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.socket.config.annotation.EnableWebSocket;

/**
 * <p>Title: WSApplication</p>
 * <p>Description: WSApplication</p>
 * <p>Company: sanjieke</p>
 *
 * @author liuweilong
 * @version 1.0
 * @date 2020/7/19
 */
@SpringBootApplication
@EnableEurekaClient
@EnableWebSocket
public class WSApplication {
    public static void main(String[] args) {
        SpringApplication.run(WSApplication.class, args);
    }
}
