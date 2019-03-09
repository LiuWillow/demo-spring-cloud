package config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lwl
 * @date 2019/3/9 9:09
 * @description 这个配置不能放在ComponentScan的类路径中，否则所有的服务都回采用这个策略
 */
@Configuration
public class MyRuleConfig {
    @Bean
    public IRule iRule(){
        return new RandomRule();
    }
}