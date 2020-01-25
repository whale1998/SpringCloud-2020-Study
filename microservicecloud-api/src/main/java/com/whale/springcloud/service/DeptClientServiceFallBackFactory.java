package com.whale.springcloud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.whale.springcloud.entity.Dept;

import feign.hystrix.FallbackFactory;

@Component   //一定要加上改注解，注册到spring中去
public class DeptClientServiceFallBackFactory implements FallbackFactory<DeptClientService> {

	@Override
	public DeptClientService create(Throwable cause) {

		// TODO 自动生成的方法存根
		return new DeptClientService() {

			@Override
			public Dept findById(Long id) {
//				返回一个自己定义的应急的方案
				return new Dept();
			}

			@Override
			public List findAll() {
//				返回一个自己定义的应急的方案
				return null;
			}

			@Override
			public boolean add(Dept dept) {
//				返回一个自己定义的应急的方案
				return false;
			}
		};
	}

}
