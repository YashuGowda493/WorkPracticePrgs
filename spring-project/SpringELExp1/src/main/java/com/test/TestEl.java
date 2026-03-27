package com.test;



import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class TestEl {

	public static void main(String[] args) {
		
		ApplicationContext ctx=new ClassPathXmlApplicationContext("beans.xml");
		Student st=ctx.getBean("std",Student.class);
		System.out.println(st);
		ExpressionParser exp=new SpelExpressionParser();
		Expression ex=exp.parseExpression("'Simple SpEL example'");
		String data=ex.getValue(String.class);
		System.out.println(data+" literals");
		
		Expression ex1=exp.parseExpression("'Simple SpEL example'".toUpperCase());
		String data1=ex1.getValue(String.class);
		System.out.println(data1);
		
		Expression ex2=exp.parseExpression("492+1");
		Integer value=ex2.getValue(Integer.class);
		System.out.println(value);
		
	}

}
