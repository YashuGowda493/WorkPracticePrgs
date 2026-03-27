package com.test.spring.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class EmployeeAnnotationAspect {
	@Before("@annotation(com.test.spring.aspects.Loggable)")
	public void myAdvice() {
		System.out.println("Executing custom advice");
	}
}
