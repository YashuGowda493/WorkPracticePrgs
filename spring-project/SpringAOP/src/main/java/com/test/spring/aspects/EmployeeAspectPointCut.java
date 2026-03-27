package com.test.spring.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class EmployeeAspectPointCut {
	@Before("getNamePointCut")
	public void loggingAdvice() {
		System.out.println("Execution logging advice on getname()");
	}
	@Before("getNamePointCut")
	public void secondAdvice() {
		System.out.println("Executing 2nd advice on getName()");
	}
	
	@Pointcut("execution(public String getName())")
	public void getNamePointCut() {
		
	}
	@Before("allMethodsPointCut")
	public void allMethodsAdvice() {
		System.out.println("before executing service()");
	}
	
	@Pointcut("within(com.test.service.*")
	public void allMethodsPointCut() {
		
	}
}
