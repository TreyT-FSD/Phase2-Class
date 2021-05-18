package com.simplilearn;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String username, password;
		
		//https://github.com/javeed512/servlets
		
		//We can do some processing on the passed in credentials here
		username = request.getParameter("username");		
		password = request.getParameter("password");
		
		if(username.compareTo("aaa") == 0) {
			//response.setHeader("Content-Type", "text/html; charset=utf-8");
			response.sendRedirect("login-success.html");
			
			//RequestDispatcher dispatcher = request.getRequestDispatcher("login-success.html");
			
		}
		else {
			//response.setHeader("Content-Type", "text/html; charset=utf-8");
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			
			
			
			out.println("Invalid Username: " + username);
			out.println("<br>");
			out.println("<br>");

			//print links to go to homepage and login page
			out.println("<a href='index.html'>Nav to homepage page</a>");
			out.println("<br>");
			out.println("<a href='login.html'>Nav to login page</a>");
		}
		
		
		/*
		//now we can generate a response
		PrintWriter out = response.getWriter();
		
		out.println("Username: " + username);
		out.println("<br>");
		out.println("Password: " + password);
		out.println("<br>");
		out.println("<br>");
		
		//print links to go to homepage and login page
		out.println("<a href='index.html'>Nav to homepage page</a>");
		out.println("<br>");
		out.println("<a href='login.html'>Nav to login page</a>");
		out.println("<br>");
		out.println("<br>");
		out.println("<a href='login-success.html'>Nav to homepage page</a>");
		
		*/
		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
