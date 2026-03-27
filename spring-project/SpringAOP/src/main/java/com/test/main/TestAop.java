package com.test.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.test.service.EmployeeService;

public class TestAop {

	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("beans.xml");
		EmployeeService service=ctx.getBean("employeeService",EmployeeService.class);
		System.out.println(service.getEmployee().getName());
		service.getEmployee().setName("sri");
//		service.getEmployee().throwException();

	}

}
