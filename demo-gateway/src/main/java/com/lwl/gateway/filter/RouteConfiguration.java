package com.lwl.gateway.filter;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author liuweilong
 * @description
 * @date 2019/6/3 14:05
 */
@Configuration
public class RouteConfiguration {
    /**
     * 将自定义filter注册到router中，访问/customer/**的路径，会在filter中打印处理时间和真实路径
     */
    @Bean
    public RouteLocator customerRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/customer/**")
                        .filters(f -> f.filter(new LwlFilter())
                                .addRequestHeader("X-LWL", "lwl'header"))
                        .uri("http://192.168.103.111:7881")
                        .order(0)
                        .id("lwl_filter"))
                .build();
    }
}
