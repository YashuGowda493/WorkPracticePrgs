package com.test;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet("/Sevlet1")
public class Sevlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
//		String name=request.getParameter("fname");
//		String company=request.getParameter("cmp");
//		String location=request.getParameter("loc");
		ServletContext ctx = getServletContext();
		String ct = ctx.getInitParameter("city");
		String st = ctx.getInitParameter("state");
		String data = ct + " " + st;

		ctx.setAttribute("info", data);

		ServletConfig cg = getServletConfig();
		String user=cg.getInitParameter("user");
		String pwd=cg.getInitParameter("pass");
		
		out.println(user+" "+pwd);

//		response.sendRedirect("userform.html");
		out.println("from servlet1: " + data);
		out.println("<br><a href='Servlet2'> next page</a>");
	}

}
