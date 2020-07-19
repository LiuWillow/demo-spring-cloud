package com.lwl.webflux;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.config.EnableWebFlux;

/**
 * author liuweilong
 * date 2020/5/27 2:00 下午
 * desc
 */
@SpringBootApplication
@EnableWebFlux
public class WebfluxApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebfluxApplication.class, args);
    }
}
