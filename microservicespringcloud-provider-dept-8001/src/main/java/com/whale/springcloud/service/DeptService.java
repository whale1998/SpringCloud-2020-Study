package com.whale.springcloud.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.whale.springcloud.dao.DeptDao;
import com.whale.springcloud.entity.Dept;


@Service
public interface DeptService {
	
	public boolean addDept(Dept dept);

	public Dept get(Long id);

	public List<Dept> list();
}
