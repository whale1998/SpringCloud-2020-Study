package com.whale.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy

/*
 * 不启用路由：http://localhost:8001/dept/findAll
 * 从zuul去找到微服务再根据条件查询
      启用路由：http://myzuul.com:9527/STUDY-SPRINGCLOUD-DEPT/dept/findAll
 */

public class ZuulGatewayApp {
	public static void main(String[] args) {
		SpringApplication.run(ZuulGatewayApp.class, args);
	}
}
