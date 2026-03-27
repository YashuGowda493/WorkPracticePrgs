package com.test.spring.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class EmployeeAspect {
	@Before("execution(public String getName())")
	public void getNameAdvice() {
		System.out.println("Executing advice on getName()");
	}
	@Before("execution(* com.test.service.*.get*())")
	public void getAllAdvice() {
		System.out.println("service () getter called");
		
	}
}
