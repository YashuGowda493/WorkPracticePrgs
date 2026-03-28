package com.test.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.test.dao.PlayerDao;
import com.test.model.Players;

public class TestJdbc {

	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("beans.xml");
		PlayerDao dao=ctx.getBean("pdao2",PlayerDao.class);
		PlayerDao dao1=ctx.getBean("pdao2",PlayerDao.class);
		Players obj=new Players();
		obj.setId(149);
		obj.setName("yashu");
		obj.setTeam("ka");
		obj.setPrice(125);
		dao1.createPlayers(obj);
//		dao.updatePlayers(obj);
		
//		dao.deletePlayers(obj);
		
	List<Players> list=dao1.getAllPlayers();
		list.forEach(System.out::println);
//		
		System.out.println("done");

	}

}
