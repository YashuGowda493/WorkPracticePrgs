package com.test;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OnetoManyDemo {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction t = session.beginTransaction();
		
		Order o1=new Order();
		o1.setO_name("Biryani");
		o1.setO_price(200);
		
		Order o2=new Order();
		o2.setO_name("Kabab");
		o2.setO_price(150);
		
		List<Order> list=Arrays.asList(o1,o2);
		
		User user=new User();
		user.setU_name("ABC");
		user.setOdr(list);
		
		User user2=new User();
		user2.setU_name("XYZ");	
		user2.setOdr(list);
		
		o1.setUser(user);
		o2.setUser(user2);
		
		session.persist(user);
		session.persist(user2);

		
		t.commit();
		System.out.println("Done.");
		
		session.close();


	}

}
