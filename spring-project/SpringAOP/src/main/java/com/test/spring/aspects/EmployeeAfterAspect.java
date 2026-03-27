package com.test.spring.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class EmployeeAfterAspect {
	
	@After("args(name)")
	public void logStringArguments(String name) {
		System.out.println("running after advice string argument passed");
	}
	@AfterThrowing("within(com.test.model.Employee)")
	public void logException(JoinPoint joinpoint) {
		System.out.println("Exception thrown in emp ()"+joinpoint.toString());
	}
	@AfterReturning(pointcut = "execution(*getName))",returning="returnstring")
	public void getNameReturningAdvice(String returnstring) {
		System.out.println("getNameReturning advice: "+returnstring);
	}
}
