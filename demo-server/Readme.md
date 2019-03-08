## 注意事项：
* 1、server和client都是基于eureka实现的，提供了服务的注册和发现，因此必须引入eureka-server依赖：
```
<dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
</dependency>
```
* 2、首先启动类添加注解`@EnableEurekaServer`
* 3、然后配置application.yml文件，启动就可以在`http://localhost:8761/`看到对应的界面
