package com.lwl.democlient.controller;

import com.lwl.democlient.service.LazyService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author lwl
 * @date 2019/3/8 17:06
 * @description
 */
@RestController
@Api(tags = "clientController哈哈哈")
@ConditionalOnClass(LazyService.class)
public class ClientController {
    @Value("${server.port}")
    private String port;

    @GetMapping("/hi")
    @ApiOperation(value = "端口")
    public String home() {
        return "port:" + port;
    }

    @GetMapping("/header/route")
    public String headerRoute(String lalal, @RequestBody String hah) {
        return "header route port:" + port + "  " + lalal + "  " + hah;
    }

    /**
     * 出异常就调用defaultStores
     */
    @HystrixCommand(fallbackMethod = "defaultStores")
    public Object getStores(Map<String, Object> parameters) {
        //do stuff that might fail
        return "success";
    }

    public Object defaultStores(Map<String, Object> parameters) {
        return "error";
    }
}