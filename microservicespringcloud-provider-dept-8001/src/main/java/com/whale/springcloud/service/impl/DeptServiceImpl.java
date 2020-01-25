package com.whale.springcloud.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whale.springcloud.dao.DeptDao;
import com.whale.springcloud.entity.Dept;
import com.whale.springcloud.service.DeptService;

@Service
public class DeptServiceImpl implements DeptService {

	@Autowired
	private DeptDao deptdao;

	@Override
	public boolean addDept(Dept dept) {

		return deptdao.addDept(dept);
	}

	@Override
	public Dept get(Long id) {
		return deptdao.findById(id);
	}

	@Override
	public List<Dept> list() {
		return deptdao.findAll();
	}

}
