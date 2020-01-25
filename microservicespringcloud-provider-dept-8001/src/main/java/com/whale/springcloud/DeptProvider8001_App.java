package com.whale.springcloud;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient  //加入注册
@EnableDiscoveryClient  //开启服务发现
public class DeptProvider8001_App {
	
	public static void main(String[] args) {
		
		SpringApplication.run(DeptProvider8001_App.class, args);
	}

}
