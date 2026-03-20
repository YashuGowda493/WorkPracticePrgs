package com.test.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JdbcCode {
	public static void main(String[] args) {
		String driver="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/mla";
		String user="root";
		String pas="root@39";
		try {
			Class.forName(driver);
			Connection con=DriverManager.getConnection(url,user,pas);
			Statement smt=con.createStatement();
			String sql="Create table mlamarch(id int primary key,name varchar(30))";
			smt.execute(sql);
			System.out.println("Done");
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	

}
