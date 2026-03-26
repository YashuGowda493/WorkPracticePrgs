package com.test;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ManytoManyDemo {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction t = session.beginTransaction();
		
		Order o1=new Order();
		o1.setO_name("Gobi");
		o1.setO_price(20);
		
		Order o2=new Order();
		o2.setO_name("panner");
		o2.setO_price(150);
		
		List<Order> list=Arrays.asList(o1,o2);
		
		Customers cs=new Customers();
		cs.setC_name("ABC");
		cs.setOrder(list);
		
		Customers cs1=new Customers();
		cs1.setC_name("XYZ");	
		cs1.setOrder(list);
		
//		o1.setUser(cs);
//		o2.setUser(cs1);
		
		session.persist(cs);
		session.persist(cs1);

		
		t.commit();
		System.out.println("Done.");
		
		session.close();


	}

}
