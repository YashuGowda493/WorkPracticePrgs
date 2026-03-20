package com.test;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("from servlet");
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String user=request.getParameter("user");
//		Cookie ck=new Cookie("info",user);
//		response.addCookie(ck);
		HttpSession ses=request.getSession();
		ServletContext ctx=getServletContext();
		ses.setAttribute("info", user);
		int total=(int)ctx.getAttribute("tusers");
		int current=(int)ctx.getAttribute("cusers");
		out.println("<h3>Total users: "+total+" current users :"+current+"</h3>");
		out.println("from login page: "+user);
		out.println("<br><a href='logout'>logout here</a>");
	}

}
