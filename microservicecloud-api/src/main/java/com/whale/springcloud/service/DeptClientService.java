package com.whale.springcloud.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.whale.springcloud.entity.Dept;

//@FeignClient(name="STUDY-SPRINGCLOUD-DEPT")
//降低耦合度，直接面向接口 提供接口中方法的预备方案
@FeignClient(value = "STUDY-SPRINGCLOUD-DEPT",fallbackFactory = DeptClientServiceFallBackFactory.class)
public interface DeptClientService {
	@RequestMapping(value = "/dept/add",method = RequestMethod.GET)
    public boolean add(Dept dept);

    @RequestMapping(value = "/dept/findById/{deptNo}",method = RequestMethod.GET)
    public Dept findById(Long id);

    @RequestMapping(value = "/dept/findAll",method = RequestMethod.GET)
    public List findAll();
}
