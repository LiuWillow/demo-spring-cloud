package com.lwl.gateway;

import com.lwl.gateway.config.ServiceHiRibbonConfig;
import com.lwl.gateway.rule.ServiceHiRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

/**
 * @author liuweilong
 * @description
 * @date 2019/6/3 10:12
 */
@SpringBootApplication
//@RibbonClients(
//        value = {
//                @RibbonClient(name = "service-hi", configuration = ServiceHiRibbonConfig.class)
//        }
//)
@EnableEurekaClient
public class GatewayApp {
    public static void main(String[] args) {
        final ConfigurableApplicationContext context = SpringApplication.run(GatewayApp.class, args);
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
