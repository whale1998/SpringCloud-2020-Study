package com.whale.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

import com.whale.NewRule.MyNewRule;

@SpringBootApplication
@EnableEurekaClient
// 自定义Ribbon的负载均衡方法，需要加入注解，指定需要执行新算法的服务名字和算法类
//注意！！算法类不能包含在启动类下的包或者其子包--->保证独一性！
/*
 * 自定义配置类不能放在@ComponentScan所扫描的当前包以及子包下，
 * 否则我们自定义的这个配置类就会被所有的Ribbon客户端锁共享，
 * 达不到特殊定制化的目的
 */
@RibbonClient(name="STUDY-SPRINGCLOUD-DEPT",configuration=MyNewRule.class)
public class DeptConsumer80_App {

	public static void main(String[] args) {
		SpringApplication.run(DeptConsumer80_App.class, args);
	}
}
