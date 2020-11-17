package com.lwl;

import com.lwl.config.ServiceHiRibbonConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@RibbonClients(
		@RibbonClient(value = "service-hi", configuration = ServiceHiRibbonConfig.class)
)
public class DemoFeignApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoFeignApplication.class, args);
	}
}
