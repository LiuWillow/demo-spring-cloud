## 注意事项
* 1、由于feign是自带断路器的，因此不需要引入hystrix，由于feign默认没有开启断路器功能，因此配置文件中需要声明`feign:hystrix:enabled: true`
* 2、用`@EnableFeignClients`注解开启feign功能
* 3、Service接口中用@FeignClient注解，value声明要调用的服务名，fallback声明发生错误时触发的类，该类需要实现这个Service接口，并且需要用@Componet注解该实现类，
@RequestMapping中声明调用Api的具体路
* 4、若出现Bean创建错误问题，可能是没有添加springboot-starter-web依赖
