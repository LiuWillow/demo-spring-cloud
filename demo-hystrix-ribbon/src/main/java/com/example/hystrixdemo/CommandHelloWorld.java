package com.example.hystrixdemo;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import rx.Observable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author liuweilong
 * @description
 * @date 2019/5/5 11:45
 */
public class CommandHelloWorld extends HystrixCommand<String> {
    private String name;
    public CommandHelloWorld(String name) {
        //指定命令组名
        super(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"));
        this.name = name;
    }

    @Override
    protected String run() throws Exception {
        Thread.sleep(2000);
        return "hello " + name + " thread : " + Thread.currentThread().getName();
    }

    @Override
    protected String getFallback() {
        return "failed " + Thread.currentThread().getName();
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        //阻塞，直到返回结果
        String s = new CommandHelloWorld("lwl").execute();
        System.out.println(s);
        //异步调用，自己来确定获取结果的时机
//        Future<String> futur = new CommandHelloWorld("lwl").queue();
        //时间不能超过command定义的超时时间，默认1秒
//        String resultFuture = futur.get(1000, TimeUnit.MILLISECONDS);
//        System.out.println(resultFuture);
        System.out.println("main thread : " + Thread.currentThread().getName());
//        Observable<String> observe = new CommandHelloWorld("lwl").observe();
//        Observable<String> toObserve = new CommandHelloWorld("lwl").toObservable();

    }
}
