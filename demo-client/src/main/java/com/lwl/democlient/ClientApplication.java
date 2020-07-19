package com.lwl.democlient;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author lwl
 * @date 2018/7/8 17:06
 * @description
 */
@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker //开启hystrix
@EnableAsync
@EnableSwagger2Doc
public class ClientApplication {
	public static void main(String[] args) {
		final ConfigurableApplicationContext run = SpringApplication.run(ClientApplication.class, args);
	}
}