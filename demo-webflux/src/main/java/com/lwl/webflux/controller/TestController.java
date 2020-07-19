package com.lwl.webflux.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * author liuweilong
 * date 2020/5/27 2:10 下午
 * desc
 */
@RestController
public class TestController {
    @GetMapping("/success")
    public String success(){
        return "success";
    }
}
