package com.ens.learn.aop.AOPlearn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ens.learn.aop.AOPlearn.dao.DataDAO;

@Service
public class BusinessService {
	
	@Autowired
	private DataDAO dao;
	
	public String doSomething()
	{
		dao.calulate2();
		return dao.calulate1();
	}

}
