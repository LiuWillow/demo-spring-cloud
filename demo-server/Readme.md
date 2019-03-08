## 注意事项：
* 1、server和client都是基于eureka实现的，只提供了服务的注册和发现（不负责请求转发），因此必须引入eureka-server依赖：
```
<dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
</dependency>
```
* 2、首先启动类添加注解`@EnableEurekaServer`
* 3、然后配置application.yml文件，启动就可以在`http://server1:8761/`看到对应的界面
