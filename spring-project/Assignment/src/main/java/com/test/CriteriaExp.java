package com.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class CriteriaExp {

	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf=cfg.buildSessionFactory();
		Session session=sf.openSession();
		Transaction t=session.beginTransaction();
//		criteria queries
		CriteriaBuilder cb=session.getCriteriaBuilder();
		CriteriaQuery<College> cq=cb.createQuery(College.class);
		cq.distinct(true);
		Root<College> rt=cq.from(College.class);
		cq.select(rt);
		TypedQuery<College> tq=session.createQuery(cq);
		List<College> list=tq.getResultList();
		System.out.println(list);
	}

}
