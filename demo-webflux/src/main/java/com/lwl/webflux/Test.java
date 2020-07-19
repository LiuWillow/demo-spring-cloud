package com.lwl.webflux;

import reactor.core.Disposable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Operators;
import reactor.core.scheduler.Scheduler;

/**
 * author liuweilong
 * date 2020/5/27 5:55 下午
 * desc
 */
public class Test {
    public static void main(String[] args) {
        Flux.just(1, 2, 3).subscribe(
                i -> System.out.println("接收到订阅：" + i),
                i -> System.err.println("接收到订阅异常：" + i),
                () -> System.out.println("订阅完成：")
        );

        Mono.error(new Exception("error"))
                .subscribe(
                        i -> System.out.println("接收到订阅：" + i),
                        i -> System.err.println("订阅发生异常：" + i),
                        () -> System.out.println("订阅完成")
                        );
    }
}
