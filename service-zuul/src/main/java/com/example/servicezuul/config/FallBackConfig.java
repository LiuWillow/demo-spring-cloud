//package com.example.servicezuul.config;
//
//import com.alibaba.fastjson.JSON;
//import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.client.ClientHttpResponse;
//
//import java.io.ByteArrayInputStream;
//import java.io.IOException;
//import java.io.InputStream;
//
///**
// * @author liuweilong
// * @description
// * @date 2019/5/21 13:56
// */
//@Configuration
//public class FallBackConfig {
//    @Bean
//    public FallbackProvider buildFallbackProvider() {
//        return new FallbackProvider() {
//            @Override
//            public String getRoute() {
//                return "*";
//            }
//
//            @Override
//            public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
//                return new ClientHttpResponse() {
//                    @Override
//                    public InputStream getBody() throws IOException {
//                        return new ByteArrayInputStream(JSON.toJSONString("请求失败").getBytes("UTF-8"));
//                    }
//                    @Override
//                    public HttpHeaders getHeaders() {
//                        HttpHeaders headers = new HttpHeaders();
//                        //和body中的内容编码一致，否则容易乱码
//                        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
//                        return headers;
//                    }
//
//                    /**
//                     * 网关向api服务请求是失败了，但是消费者客户端向网关发起的请求是OK的，
//                     * 不应该把api的404,500等问题抛给客户端
//                     * 网关和api服务集群对于客户端来说是黑盒子
//                     */
//                    @Override
//                    public HttpStatus getStatusCode() throws IOException {
//                        return HttpStatus.OK;
//                    }
//
//                    @Override
//                    public int getRawStatusCode() throws IOException {
//                        return HttpStatus.OK.value();
//                    }
//
//                    @Override
//                    public String getStatusText() throws IOException {
//                        return HttpStatus.OK.getReasonPhrase();
//                    }
//
//                    @Override
//                    public void close() {}
//                };
//            }
//        };
//    }
//}
