package com.test.spring.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class EmployeeAroundAspect {
	@Around("execution(* com.test.model.Employee.getName())")
	public Object employeeAroundAdvice(ProceedingJoinPoint proceedingjoinpoint) {
		System.out.println("before invoking getname()");
		Object value=null;
		try {
			value=proceedingjoinpoint.proceed();
		}catch(Throwable e) {
			e.printStackTrace();
		}
		System.out.println("After invoking getname()");
		return value;
	}
}
