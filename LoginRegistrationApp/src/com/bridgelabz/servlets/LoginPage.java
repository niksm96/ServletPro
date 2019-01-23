package com.bridgelabz.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		response.setContentType("text/html");
		PrintWriter printWriter = response.getWriter();
		printWriter.write("<html><body><div id='serlvetResponse' style='text-align:center;'>");
		RequestDispatcher requestDispatcher = null;
		if ((username.equalsIgnoreCase("nik")) && (password.equals("nik@123"))) {
			HttpSession session=request.getSession();  
		    session.setAttribute("name",username);  
			requestDispatcher=request.getRequestDispatcher("/logout.html");
			requestDispatcher.forward(request, response);
		} else {
			printWriter.println("You are not authorized user, please sign up!");
			requestDispatcher = request.getRequestDispatcher("/Index.html");
			requestDispatcher.include(request, response);
		}
		printWriter.println("</div></body></html>");
		printWriter.close();
	}
}
