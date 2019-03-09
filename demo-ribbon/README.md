## 注意事项
* 1、ribbon存在的意义是实现服务之间相互调用和客户端负载均衡，eureka中已经有ribbon依赖，不需要再加入
* 2、配置服务中心地址，服务名称
* 3、启动类用@EnableDiscoveryClient
* 4、创建`RestTemplate`Bean，在这个Bean上添加`@LoadBalanced`注解实现负载均衡，调用`restTemplate.getForObject("http://注册的服务名称/hi", 
String.class)`即可使用其他服务
* 5、在test中测试的时候可能会出现`java.lang.IllegalStateException: Shutdown in progress`，在Controller中不会有这个异常
* 6、可以通过IRule指定负载均衡策略，也可以继承AbstractLoadBalancerRule实现自己的负载均衡算法
## 服务端负载均衡
服务1通过nginx反向代理，调用服务2的过程中，服务1不知道究竟有多少个服务，负载均衡策略由nginx决定，称为服务端负载均衡
## 客户端负载均衡
服务1先到eureka中获取注册的所有服务，然后通过ribbon来决定调用哪一个服务实例，负载均衡策略在服务1中决定，称为客户端负载均衡
