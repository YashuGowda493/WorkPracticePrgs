package com.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class CollegeDao {
	public static SessionFactory getDBSessionF() {
		
		SessionFactory factory=null;
		try {
//			Configuration cfg=new Configuration();
//			cfg.configure("hibernate.cfg.xml");
			factory=HibernateUtil.getSessionFactory();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return factory;
		
	}
	
	public void saveCollege(College obj) {
		Session session=CollegeDao.getDBSessionF().openSession();
		Transaction t=session.beginTransaction();
		session.persist(obj);
		t.commit();
		session.close();
	}
	public List<College> listAllCollege(){
		Session session=CollegeDao.getDBSessionF().openSession();
//		Transaction t=session.beginTransaction();
		Query<College> q=session.createQuery("from College",College.class);
		List<College> list=q.list();
		session.close();
		return list;
		
	}
	public void updateCollege(College obj) {
		Session session=CollegeDao.getDBSessionF().openSession();
		Transaction t=session.beginTransaction();
		College dt=session.find(College.class, obj.getId());
		dt.setClg_name(obj.getClg_name());
		dt.setClg_city(obj.getClg_city());
		dt.setClg_pincode(obj.getClg_pincode());
		dt.setYear(obj.getYear());
		session.persist(dt);
		t.commit();
		session.close();
	}
	public void deleteCollege(College obj) {
		Session session=CollegeDao.getDBSessionF().openSession();
		Transaction t=session.beginTransaction();
		session.remove(obj);
		t.commit();
		session.close();
	}

}
