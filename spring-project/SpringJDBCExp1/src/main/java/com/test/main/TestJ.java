package com.test.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.test.config.DBConfig;
import com.test.dao.PlayerDao;
import com.test.dao.PlayerDao2;
import com.test.model.Players;

public class TestJ {

	public static void main(String[] args) {
		ApplicationContext ctx=new AnnotationConfigApplicationContext(DBConfig.class);
		PlayerDao2 dao=ctx.getBean(PlayerDao2.class);
//		PlayerDao dao1=ctx.getBean("pdao2",PlayerDao.class);
		Players obj=new Players();
		obj.setId(222);
		obj.setName("accd");
		obj.setTeam("RCB");
		obj.setPrice(12346);
//		dao.createPlayers(obj);
		dao.updatePlayers(obj);
		List<Players> list=dao.listAll();
		list.forEach(System.out::println);
		System.out.println("done");
	
	}
	
	

}
