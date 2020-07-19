package com.lwl.democlient.job;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.annotation.XxlJob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * author liuweilong
 * date 2020/5/22 6:06 下午
 * desc
 */
@Component
@Slf4j
public class TestHandler {
    @XxlJob("testHandler")
    public ReturnT<String> testHandler(String params) throws InterruptedException {
        log.info("------------开始执行");
        return ReturnT.SUCCESS;
    }
}
