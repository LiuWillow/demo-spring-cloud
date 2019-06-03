package com.lwl.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

/**
 * @author liuweilong
 * @description
 * @date 2019/6/3 10:12
 */
@SpringBootApplication
public class GatewayApp {
    public static void main(String[] args) {
        SpringApplication.run(GatewayApp.class, args);
    }

//    @Bean
//    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
//        return builder.routes()
//                .route(p -> p.path("/hi")  //hi都转发到http://192.168.103.111:7881/hi
//                        .filters(f -> f.addRequestHeader("Hello", "World"))
//                        .uri("http://192.168.103.111:7881"))
//                .build();
//    }
}
