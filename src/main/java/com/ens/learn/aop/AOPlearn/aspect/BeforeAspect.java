package com.ens.learn.aop.AOPlearn.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
//Aspect class
@Configuration
public class BeforeAspect {

	Logger logger = LoggerFactory.getLogger(BeforeAspect.class);

	// PointCut
	@Before("com.ens.learn.aop.AOPlearn.aspect.CommonPointCut.DaoPointCut()")
	public void BeforeDao(JoinPoint jp) // Specific instance
	{ // Advice
		logger.info("Enter A DOA mehtod {} ", jp);
	}

	@Before("execution(* com.ens.learn.aop.AOPlearn.service.*.*(..))")
	public void BeforeService(JoinPoint jp) {
		logger.info("Enter A service mehtod {} ", jp);
		
	}

	@After("com.ens.learn.aop.AOPlearn.aspect.CommonPointCut.DaoPointCut()")
	public void AFterDao(JoinPoint jp) {
		System.out.println("Exit A DAO mehtod:" + jp);
	}

	@After("execution(* com.ens.learn.aop.AOPlearn.service.*.*(..))")
	public void AfterService(JoinPoint jp) {
		System.out.println("Exit A Service mehtod:" + jp);
	}

	@AfterReturning(value = "com.ens.learn.aop.AOPlearn.aspect.CommonPointCut.DaoPointCut()", returning = "oj")
	public void afterReturn(JoinPoint jp, Object oj) {
		System.out.println("After mehtod" + jp + "Returned=" + oj);

	}

	@AfterThrowing(value = "execution(* com.ens.learn.aop.AOPlearn.dao.*.*(..))", throwing = "obj")
	public void AfterDAOThrowing(JoinPoint jp, Object obj) {
		System.out.println("Exception at DAO method" + jp);
		System.out.println("Actaul Exception is " + obj.toString());
	}

	@Around("com.ens.learn.aop.AOPlearn.aspect.CommonPointCut.TimeTrackPointCut()")
	public void AroundDao(ProceedingJoinPoint jp) throws Throwable {
		System.out.println("around with PointCut");
		long sT = System.currentTimeMillis();
		jp.proceed();
		System.out.println("total time=" + (System.currentTimeMillis() - sT));
	}

}
