package com.ens.learn.aop.AOPlearn.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.ens.learn.aop.AOPlearn.aspect.TimeTrack;



@Repository
@Primary
public class DataDAO {

	
    @TimeTrack
	public String  calulate1()
	{
		String s=Math.random()+"";
		return s;
	}
	
	public void calulate2()
	{
		if(1==2)
		{
			throw new RuntimeException("My Exception");
		}
	}
}
