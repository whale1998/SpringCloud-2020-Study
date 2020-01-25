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

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.whale.springcloud.entity.Dept;
import com.whale.springcloud.service.DeptClientService;
import com.whale.springcloud.service.DeptService;


@RestController
public class DeptController {

	@Autowired
	private DeptClientService deptService;
	
	@RequestMapping(value = "/dept/findById/{deptNo}",method = RequestMethod.GET)
//	@HystrixCommand(fallbackMethod="processHystrixGet") 
//	在实际工作中，这样的方法耦合度太高 每个方法就需要提供一个预备方案，因此需要解耦  参照api工程下 直接在接口上面
	public Dept findById(Long deptNo) {
	    Dept deptEntity = deptService.findById(deptNo);
	    if(null ==deptEntity){
	        throw  new RuntimeException("该deptNo没有对应的信息"+deptNo);
	    }
	    return  deptEntity;
	}

	 public Dept processHystrixGet(Long deptNo){
	        return  new Dept();
	    }


	
}
