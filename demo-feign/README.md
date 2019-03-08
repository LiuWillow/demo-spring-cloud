## 注意事项
* 1、feign本质上就是ribbon+hytrix，默认实现了负载均衡，优点在于代码更有亲和力，可以用注解的方式，将服务转换为本地接口，需要引入依赖：
```
<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-feign</artifactId>
</dependency>
```
* 2、主类要用注解`@EnableDiscoveryClient`和`@EnableFeignClients`，在服务接口中用`@FeignClient`注解，`value = "service-hi"`指定所要调用的服务名称，
`@RequestMapping`的`value`为服务下相对路径名
* 3、配置类指定注册服务地址
