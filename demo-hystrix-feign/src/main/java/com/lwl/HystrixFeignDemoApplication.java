package com.lwl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * date  2018/6/14
 * author liuwillow
 **/
@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class HystrixFeignDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(HystrixFeignDemoApplication.class, args);
    }
}