package com.test.spring.aspects;

import org.aspectj.lang.ProceedingJoinPoint;

public class EmployeeXMLConfigAspect {
	public Object employeeAroundAdvice(ProceedingJoinPoint joinpoint) {
		System.out.println("EmployeeXMLConfigAspect :: Before invoking getName() ");
		Object value=null;
		try {
			value=joinpoint.proceed();
		}catch(Throwable e) {
			e.printStackTrace();
		}
		System.out.println("EmployeeXMLConfigAspect :: after invoking getName() ");
		return value;
	}
}
