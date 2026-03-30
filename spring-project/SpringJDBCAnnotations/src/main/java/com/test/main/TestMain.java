package com.test.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.test.config.DBConfig;
import com.test.dao.BookDao;
import com.test.model.Book;


public class TestMain {

	public static void main(String[] args) {
		ApplicationContext ctx=new AnnotationConfigApplicationContext(DBConfig.class);
		BookDao dao=ctx.getBean(BookDao.class);
		Book bk=new Book();
		bk.setB_id(12);
		bk.setB_name("you can win");
		bk.setB_author("PU");
		bk.setB_price(1100);
//		dao.saveBooks(bk);
//		dao.updateBooks(bk);
		dao.deleteBooks(bk);
		List<Book> list=dao.listAllBooks();
		list.forEach(System.out::println);
		System.out.println("Done");

	}

}
