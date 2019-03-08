package com.lwl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * date  2018/6/14
 * author liuwillow
 **/
@SpringBootApplication
@EnableFeignClients
public class HystrixFeignDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(HystrixFeignDemoApplication.class, args);
    }
}
