package com.test;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/ListUsers")
public class ListUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			String query = "select * from users";
			PreparedStatement ps = DbConnection.getCon().prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			List<User> listusers = new ArrayList<>();
			while (rs.next()) {
				User obj = new User();
				obj.setId(rs.getInt(1));
				obj.setFname(rs.getString(2));
				obj.setUsername(rs.getString(3));
				obj.setPassword(rs.getString(4));
				listusers.add(obj);

			}
			ServletContext ctx=getServletContext();
			ctx.setAttribute("info",listusers);
			
			if(listusers.size()>0) {
				System.out.println(listusers.size());
				response.sendRedirect("listusers.jsp");
			}
			else {
				out.println("<center><font color='red'>No Data Available</font></center>");
				RequestDispatcher rd=request.getRequestDispatcher("register.jsp");
				rd.include(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

}
