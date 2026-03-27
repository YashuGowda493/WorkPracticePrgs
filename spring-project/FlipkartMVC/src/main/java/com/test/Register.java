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
import java.util.regex.Pattern;

@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String name=request.getParameter("fname");
		String user=request.getParameter("user");
		String pwd=request.getParameter("pwd");
		User obj=new User();
		obj.setFname(name);
			
		obj.setUsername(user);
		obj.setPassword(pwd);
		
		String query="insert into users(full_name,u_name,u_pass) values(?,?,?)";
		PreparedStatement ps=DbConnection.getCon().prepareStatement(query);
		ps.setString(1, obj.getFname());
		ps.setString(2, obj.getUsername());
		ps.setString(3, obj.getPassword());
		ps.execute();
		
		Pattern p=Pattern.compile("[a-zA-Z]+");
		if(p.matches(name,obj.getFname()) && p.matches(user,obj.getUsername()) &&p.matches(pwd,obj.getPassword())) {
			response.sendRedirect("login.jsp");
		}
		else {
			out.println("<center><font color='red'>Registration failed</font><center>");
			RequestDispatcher rd=request.getRequestDispatcher("register.jsp");
			rd.include(request, response);
		
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
