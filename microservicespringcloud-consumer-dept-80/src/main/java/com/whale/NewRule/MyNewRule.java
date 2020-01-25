package com.whale.NewRule;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

@Configuration
public class MyNewRule {
	
	@Bean
	public IRule myRule() {
//		返回自己写的算法去指定
		return new MyRule_Whale(); 
	}

}
