package com.lwl;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * date  2018/6/14
 * author liuwillow
 **/
@RestController
public class Controller {
    @Resource
    HiService hiService;

    @GetMapping("/hi")
    public String hi(){
        return hiService.hi();
    }
}
