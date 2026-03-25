package com.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibInheritDemo {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction t = session.beginTransaction();
		College cobj = new College();
		cobj.setClg_name("KLE");
		cobj.setClg_city("RJnagar");
		
		PrivateClg pobj = new PrivateClg();
		pobj.setClg_name("MES");
		pobj.setFees(500000);
		
		
		GovtClg gobj = new GovtClg();
		gobj.setClg_name("Sheshadripuram");
	
		gobj.setSchlorship(25000);

		session.persist(cobj);
		session.persist(pobj);

		session.persist(gobj);

		t.commit();
		System.out.println("Done");
	}

}
