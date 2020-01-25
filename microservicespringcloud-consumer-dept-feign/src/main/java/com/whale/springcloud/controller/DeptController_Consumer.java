package com.whale.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.whale.springcloud.entity.Dept;
import com.whale.springcloud.service.DeptClientService;

@Controller
public class DeptController_Consumer {

	@Autowired
	private DeptClientService deptClientService;

	@RequestMapping(value = "/consumer/dept/add")
	public boolean add(Dept deptEntity) {
		// 三个参数：url,requestMap ResponseBean.class
		return deptClientService.add(deptEntity);
	}

	@RequestMapping("/consumer/dept/findById/{deptNo}")
	public Dept findById(Long deptNo) {
		// 三个参数：url,requestMap ResponseBean.class
		return deptClientService.findById(deptNo);
	}

	@RequestMapping("/consumer/dept/findAll")
	public List findAll() {
		// 三个参数：url,requestMap ResponseBean.class
		return deptClientService.findAll();
	}
}
