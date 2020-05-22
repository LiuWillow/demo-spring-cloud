package com.lwl.democlient.service;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * author liuweilong
 * date 2020/5/18 11:16 上午
 * desc
 */
@Service
public class TaskService {
    @Resource
    @Lazy
    private MessageService messageService;


    public void lala(){
        messageService.send();
    }

    public void shit(){
        System.out.println();
    }

}
