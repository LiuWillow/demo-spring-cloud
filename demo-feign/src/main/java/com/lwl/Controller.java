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
    @Autowired(required = false)
    private HiClient hiClient;

    @GetMapping("/hi")
    public String hi(){
        Long draftId = 1L;
        return hiClient.serviceHi(new TestParam(), draftId);

    }
}