package com.lwl;

import config.MyRuleConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * date  2018/6/13
 * author liuwillow
 **/
@SpringBootApplication
@EnableDiscoveryClient
//指定某个服务使用哪个负载均衡策略
@RibbonClients(
        @RibbonClient(name = "service-hi", configuration = MyRuleConfig.class)
)
public class RibbonApplication {
    public static void main(String[] args) {
        SpringApplication.run(RibbonApplication.class, args);
    }
}
