package com.lwl.democlient.config;

import org.springframework.context.annotation.Bean;

/**
 * <p>Title: ShitConfig</p>
 * <p>Description: ShitConfig</p>
 * <p>Company: sanjieke</p>
 *
 * @author liuweilong
 * @version 1.0
 * @date 2020/8/4
 */
public class ShitConfig {
    @Bean
    public String config1(){
        return "sss";
    }

    @Bean
    public String config2() {
        return config1() + "1";
    }
}