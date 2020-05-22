package com.lwl.democlient.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.HandlerMapping;
import springfox.documentation.spring.web.DocumentationCache;
import springfox.documentation.spring.web.PropertySourcedRequestMappingHandlerMapping;
import springfox.documentation.spring.web.json.JsonSerializer;
import springfox.documentation.swagger2.mappers.ServiceModelToSwagger2Mapper;
import springfox.documentation.swagger2.web.Swagger2Controller;

/**
 * author liuweilong
 * date 2020/5/21 6:23 下午
 * desc
 */
@Configuration
public class ControllerConfig {
    @Bean
    public HandlerMapping swagger2ControllerMapping3(
            Environment environment,
            DocumentationCache documentationCache,
            ServiceModelToSwagger2Mapper mapper,
            JsonSerializer jsonSerializer) {
        return new PropertySourcedRequestMappingHandlerMapping(
                environment,
                new Swagger2Controller(environment, documentationCache, mapper, jsonSerializer));
    }
}
