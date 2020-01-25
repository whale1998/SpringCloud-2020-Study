package com.whale.springcloud.cfgbeans;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.netflix.loadbalancer.AvailabilityFilteringRule;
import com.netflix.loadbalancer.BestAvailableRule;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RetryRule;
import com.netflix.loadbalancer.RoundRobinRule;
import com.netflix.loadbalancer.WeightedResponseTimeRule;
import com.netflix.loadbalancer.ZoneAvoidanceRule;

@Configuration
public class ConfigBean {

	@Bean
	@LoadBalanced //ribbon实现的一套 基于《客户端、负载均衡》的工具  每次客户端都需要从这里调用。 
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
//	制定负载均衡的算法， 构建一个方法 返回一个对象即可
	@Bean
	public IRule myRule() {
//		return new RoundRobinRule();  轮询
		return new RandomRule(); //随机
//		return new AvailabilityFilteringRule(); 过滤掉多次访问故障的服务，剩下的再轮询
//		return new WeightedResponseTimeRule(); 根据平均响应时间
//		return new RetryRule();   按照轮询策略获取服务，失败就重试
//		return new BestAvailableRule();   过滤掉多次访问失败的服务，选取并发量最小的服务
//		return new ZoneAvoidanceRule();  根据性能和可用性去选择服务
	}
}
