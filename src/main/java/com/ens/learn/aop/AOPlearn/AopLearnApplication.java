package com.ens.learn.aop.AOPlearn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.ens.learn.aop.AOPlearn.service.BusinessService;

@SpringBootApplication
public class AopLearnApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ac=SpringApplication.run(AopLearnApplication.class, args);
		BusinessService bs=ac.getBean(BusinessService.class);
		System.out.println("main");
		System.out.println(bs.doSomething());
	}
}
