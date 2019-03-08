## 注意事项
* 1、ribbon存在的意义是实现服务之间相互调用，需要引入依赖：
```
<dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-ribbon</artifactId>
</dependency>
```
* 2、配置服务中心地址，服务名称
* 3、启动类用@EnableDiscoveryClient
* 4、创建`RestTemplate`Bean，在这个Bean上添加`@LoadBalanced`注解实现负载均衡，调用`restTemplate.getForObject("http://注册的服务名称/hi", 
String.class)`即可使用其他服务
* 5、在test中测试的时候可能会出现`java.lang.IllegalStateException: Shutdown in progress`，在Controller中不会有这个异常
