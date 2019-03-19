package com.lwl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
/**
 * @author lwl
 * @date 2018/7/8 17:06
 * @description
 */
@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker //开启hystrix
public class ClientApplication {
	public static void main(String[] args) {
		SpringApplication.run(ClientApplication.class, args);
	}
}
