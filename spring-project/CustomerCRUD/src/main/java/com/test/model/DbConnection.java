package com.test.model;


import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
	public static Connection getCon() {
		String driver="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/mla";
		String user="root";
		String pass="root@39";
		Connection con=null;
		
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,user,pass);
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		return con;
		
	}

}
