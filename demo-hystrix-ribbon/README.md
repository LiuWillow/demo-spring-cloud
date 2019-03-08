## 注意事项
* 1、断路器是在服务调用的过程中，调用方出现问题时的解决方案，可以设置该Api返回一个默认值。需要引入依赖：
```
<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-hystrix</artifactId>
</dependency>
```
* 2、主类要用`@EnableDiscoveryClient`和`@EnableHystrix`注解
* 3、该项目是ribbon和hystrix结合，因此需要创建`RestTemplate`并用`@LoadBalanced`开启负载均衡
* 4、配置文件中同样要声明注册服务地址
* 5、在Service方法中，通过`@HystrixCommand`注解，`fallbackMethod = "hiError"`指定服务出错时的默认执行方法
