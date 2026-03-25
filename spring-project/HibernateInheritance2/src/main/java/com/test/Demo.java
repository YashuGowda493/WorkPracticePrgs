package com.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Demo {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction t = session.beginTransaction();
		Movie vobj = new Movie();
		vobj.setM_name("magadeera");
		vobj.setM_location("India");
		TwoD tobj = new TwoD();
		tobj.setM_name("KGF");

		tobj.setCasting("yash");
//		TwoWheeler tobj1=new TwoWheeler();
//		tobj1.setV_name("scooter");
//		tobj1.setLcn_no(43365);
//		tobj1.setSteeringHandle("scooty Steering handle");
		ThreeD fobj = new ThreeD();
		fobj.setM_name("AI animation");
//		fobj.setLcn_no(234156);
		fobj.setDirector("Upendra");

		session.persist(vobj);
		session.persist(tobj);
//		session.persist(tobj1);
		session.persist(fobj);

		t.commit();
		System.out.println("Done");
	}

}
