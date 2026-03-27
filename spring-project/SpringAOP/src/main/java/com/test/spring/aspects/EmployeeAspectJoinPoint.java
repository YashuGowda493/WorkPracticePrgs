package com.test.spring.aspects;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class EmployeeAspectJoinPoint {
	@Before("execution(public void com.test.model.Set*(*))")
	public void logginAdvice(JoinPoint joinpoint) {
		System.out.println("Before executing login advice on (): "+joinpoint.toString());
		System.out.println("Arguments passed : "+Arrays.toString(joinpoint.getArgs()));
	}
	@Before("args(name)")
	public void logStringArguments(String name) {
		System.out.println("String argument passed:"+name);
	}
}
