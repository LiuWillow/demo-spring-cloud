## 注意事项
* 1、config-server的作用是作为一个配置中心，让其他项目可以远程读取该配置，需要引入：
```
<dependency>
  <groupId>org.springframework.cloud</groupId>
  <artifactId>spring-cloud-config-server</artifactId>
</dependency>
```
* 2、`@EnableConfigServer`注解开启config功能，配置文件中配置文件的地址、路径以及分支
* 3、访问`ip:port/field/profile`即可，如配置文件名为app-dev.properties，则访问`ip:port/app/dev`
