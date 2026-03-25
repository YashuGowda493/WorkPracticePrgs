package com.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class InheritanceDemo {

	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf=cfg.buildSessionFactory();
		Session session=sf.openSession();
		Transaction t=session.beginTransaction();
		Vehicle vobj=new Vehicle();
		vobj.setV_name("car");
		vobj.setLcn_no(1234543);
		TwoWheeler tobj=new TwoWheeler();
		tobj.setV_name("Bike");
		tobj.setLcn_no(132465);
		tobj.setSteeringHandle("Bike Steering handle");
		TwoWheeler tobj1=new TwoWheeler();
		tobj1.setV_name("scooter");
		tobj1.setLcn_no(43365);
		tobj1.setSteeringHandle("scooty Steering handle");
		FourWheeler fobj=new FourWheeler();
		fobj.setV_name("truck");
//		fobj.setLcn_no(234156);
		fobj.setSteeringWheel("Ai Steering wheel");
		
		session.persist(vobj);
		session.persist(tobj);
		session.persist(tobj1);
		session.persist(fobj);
		
		t.commit();
		System.out.println("Done");
	}

}
