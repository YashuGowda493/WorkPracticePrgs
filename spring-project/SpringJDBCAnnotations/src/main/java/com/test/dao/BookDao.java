package com.test.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.test.model.Book;
import com.test.model.BookMapper;

@Component
@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.SERIALIZABLE)
public class BookDao {
	private JdbcTemplate jdbcTemplate;
	public BookDao(DataSource dataSource) {
		this.jdbcTemplate=new JdbcTemplate(dataSource);
		
	}
	private final String ins_sql="insert into books(b_id,b_name,b_author,b_price) values (?,?,?,?)";
	private final String upd_sql="update books set b_name=?,b_author=?,b_price=? where b_id=?";
	private final String del_sql="delete from books where b_id=?";
	private final String read_sql="select * from books";
	
	public boolean saveBooks(Book bk) {
	
		return jdbcTemplate.update(ins_sql,bk.getB_id(),bk.getB_name(),bk.getB_author(),bk.getB_price())>0;
	}
	public boolean updateBooks(Book bk) {
		return jdbcTemplate.update(upd_sql,bk.getB_name(),bk.getB_author(),bk.getB_price(),bk.getB_id())>0;
	}
	public boolean deleteBooks(Book bk) {
		return jdbcTemplate.update(del_sql,bk.getB_id())>0;
	}
	public List<Book> listAllBooks(){
		return jdbcTemplate.query(read_sql, new BookMapper());
	}

}
