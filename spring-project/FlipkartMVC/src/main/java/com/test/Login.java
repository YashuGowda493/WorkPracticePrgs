package com.test;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String user=request.getParameter("user");
		String pwd=request.getParameter("pwd");
		User obj=new User();
		obj.setUsername(user);
		obj.setPassword(pwd);
		
		String query="select u_name,u_pass from users where u_name= ? and u_pass=?";
		PreparedStatement ps=DbConnection.getCon().prepareStatement(query);
		ps.setString(1, user);
		ps.setString(2, pwd);
//		
		ResultSet rs=ps.executeQuery();
		User ob1=new User();
		while(rs.next()) {
			ob1.setUsername(rs.getString(1));
			ob1.setPassword(rs.getString(2));
		}
		if(obj.getUsername().equals(ob1.getUsername()) && obj.getPassword().equals(ob1.getPassword())) {
			response.sendRedirect("home.jsp");
		}
		else {
			out.println("<center><font color='red'>Invalid Credentials</font></center>");
			RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
			rd.include(request, response);
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
