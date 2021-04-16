package com.ibm.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String userid=request.getParameter("userid");
		String password=request.getParameter("password");
		
		PrintWriter out =response.getWriter();
		response.setContentType("text/html");
		if(userid.equals("Satya") && password.equals("java")) {
			// Login success
			response.sendRedirect("hello.jsp");
		//	out.print("<h1> login</h1>");
		}else {
			//Login failed
			response.sendRedirect("login.jsp");
			//out.print("<h1> login fail</h1>");
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
