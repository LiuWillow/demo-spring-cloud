package com.lwl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * date  2018/6/29
 * author liuwillow
 **/
@RestController
public class Controller {
    @Autowired
    private HiService hiService;

    @GetMapping("/hi")
    public String hi(){
        return hiService.serviceHi();
    }
}
