package com.lwl.democlient.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * author liuweilong
 * date 2020/5/18 11:16 上午
 * desc
 */
@Service
public class MessageService {
    @Resource
    private TaskService taskService;
    @Async
    public void send(){
        taskService.shit();
    }
}
