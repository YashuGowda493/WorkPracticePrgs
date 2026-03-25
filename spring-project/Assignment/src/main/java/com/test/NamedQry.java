package com.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class NamedQry {

	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf=cfg.buildSessionFactory();
		Session session=sf.openSession();
		Transaction t=session.beginTransaction();
//		Query query=session.createNamedQuery("customquery");
//		query.setParameter("name", "ramaih");
		Query query1=session.createNamedQuery("cityquery");
		query1.setParameter("city", "yelahka");
//		List list=query.list();
//		System.out.println(list);
		List list1=query1.list();
		System.out.println(list1);
		session.close();
	}

}
