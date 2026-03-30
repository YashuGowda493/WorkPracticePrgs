package com.test.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class BookMapper implements RowMapper<Book> {

	@Override
	public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
		Book bk=new Book();
		bk.setB_id(rs.getInt("b_id"));
		bk.setB_name(rs.getString("b_name"));
		bk.setB_author(rs.getString("b_author"));
		bk.setB_price(rs.getInt("b_price"));
		return bk;
	}

}
