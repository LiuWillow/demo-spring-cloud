package com.lwl.democlient.service;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * author liuweilong
 * date 2020/5/18 5:51 下午
 * desc
 */
@Service
public class LazyService {
    @Resource
    @Lazy
    private ShitService shitService;

    public void sdf(){
        System.out.println();
    }
}
