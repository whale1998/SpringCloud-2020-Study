package com.whale.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.whale.springcloud.entity.Dept;

@Controller
public class DeptController_Consumer {

//	private static final String REST_URL_PREFIX = "http://localhost:8001";
//	基于ribbon与euraka  现在不需要去关注IP和端口了，只需要知道微服务名称便能调用服务
	private static final String REST_URL_PREFIX = "http://STUDY-SPRINGCLOUD-DEPT";
	

	@Autowired
	private RestTemplate restTemplate;

//	三个参数 1.URL 2.所带的参数  3.返回结果类型
	@RequestMapping("/consumer/dept/add/")
	public boolean add(Dept dept) {
		return restTemplate.postForObject(REST_URL_PREFIX + "/dept/add", dept, Boolean.class);
	}

	@RequestMapping("/consumer/dept/add/{id}")
	public Dept get(@PathVariable("id") Long id) {
		return restTemplate.getForObject(REST_URL_PREFIX + "/dept/get/" + id, Dept.class);
	}

	@RequestMapping("/consumer/dept/list")
	public List<Dept> list() {
		return restTemplate.getForObject(REST_URL_PREFIX + "/dept/list", List.class);
	}

//	在消费端去发现注册的服务！
	@RequestMapping(value = "/consumer/dept/discovery")
	public Object discovery() {
		return restTemplate.getForObject(REST_URL_PREFIX + "/dept/discovery", Object.class);
	}
}
