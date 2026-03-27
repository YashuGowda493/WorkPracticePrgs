package com.test;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDemo {

	public static void main(String[] args) {
//		ApplicationContext ctx=new ClassPathXmlApplicationContext("beans.xml");
//		Employee ob=ctx.getBean("emp",Employee.class);
//		System.out.println(ob);
		ApplicationContext ctx=new AnnotationConfigApplicationContext(AnnConfig.class);
		Address adr=ctx.getBean("getAdrObj",Address.class);
		adr.setCity("blore");
		adr.setState("KA");
		Address adr1=ctx.getBean("getAdrObj",Address.class);
		adr1.setCity("mys");
		adr1.setState("KA");
		List<Address> list=Arrays.asList(adr,adr1);
		Employee empl=ctx.getBean("getEmpObj",Employee.class);
		empl.setId(11);
		empl.setName("yashu");
		empl.setCompany("mph");
		empl.setAdr(list);
		
		System.out.println(empl);

	}

}
