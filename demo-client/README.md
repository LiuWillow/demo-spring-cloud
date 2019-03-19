## 注意事项
* 1、client也是基于eureka实现，因此需要引入eureka依赖：
```
 <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
 </dependency>
```
* 2、首先在启动类上添加`@EnableEurekaClient`和`@SpringBootApplication`
* 3、配置application.yml文件，指定注册server的地址和该client的名称，然后登录`http://server1:8761/`就可以看到该服务成功注册
* 4、改变port，可以看到成功注册了两个服务，相当于一个集群
* 5、eurekaClient默认用Jersey进行HTTP通信，如果不想用，可以拒绝：
```
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
    <exclusions>
        <exclusion>
            <groupId>com.sun.jersey</groupId>
            <artifactId>jersey-client</artifactId>
        </exclusion>
        <exclusion>
            <groupId>com.sun.jersey</groupId>
            <artifactId>jersey-core</artifactId>
        </exclusion>
        <exclusion>
            <groupId>com.sun.jersey.contribs</groupId>
            <artifactId>jersey-apache-client4</artifactId>
        </exclusion>
    </exclusions>
</dependency>
```

