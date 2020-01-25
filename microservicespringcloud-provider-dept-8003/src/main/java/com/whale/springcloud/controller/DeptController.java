package com.whale.springcloud.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.whale.springcloud.entity.Dept;
import com.whale.springcloud.service.DeptService;


@RestController
public class DeptController {

	@Autowired
	private DeptService deptservice;

	@Autowired
	private DiscoveryClient discoveryClient;

	
	@RequestMapping("/dept/add")
	public boolean addDept(@RequestBody Dept dept) {
		return deptservice.addDept(dept);
	}

	@RequestMapping("/dept/get/{id}")
	public Dept get(@PathVariable Long id) {
		return deptservice.get(id);
	}

	@RequestMapping("/dept/list")
	public List<Dept> list(){
		return deptservice.list();
	}
	
//	发现注册的服务，若在上百上千的服务去寻找会很困难，使用服务的发现则能快速的找到对应的服务
	@RequestMapping(value = "/dept/discovery",method = RequestMethod.GET)
	public Object discovery(){
//		获取所有的服务名称
	    List<String> list = discoveryClient.getServices();
//	    发现对应服务的名称
	    List<ServiceInstance> instances = discoveryClient.getInstances("STUDY-SPRINGCLOUD-DEPT");
//	  得到对应服务的各项信息
	    for (ServiceInstance element :instances){
	        System.out.println(element.getServiceId());
	        System.out.println(element.getHost());
	        System.out.println(element.getPort());
	        System.out.println(element.getUri());
	    }
	    return this.discoveryClient;

	}

	
}
