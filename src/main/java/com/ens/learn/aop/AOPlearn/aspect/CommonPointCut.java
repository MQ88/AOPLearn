package com.ens.learn.aop.AOPlearn.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class CommonPointCut {
	
//@Pointcut("execution(* com.ens.learn.aop.AOPlearn.dao.*.*(..))")
@Pointcut("within(com.ens.learn.aop.AOPlearn.dao.*)")
public void DaoPointCut()
{
	
}

@Pointcut("@annotation(com.ens.learn.aop.AOPlearn.aspect.TimeTrack)")
public void TimeTrackPointCut()
{
	
}


}

