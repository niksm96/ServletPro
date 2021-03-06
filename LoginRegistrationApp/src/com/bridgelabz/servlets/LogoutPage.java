package com.bridgelabz.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html");
		PrintWriter printWriter = response.getWriter();
		HttpSession session = request.getSession(false);
		session.invalidate();
		RequestDispatcher requestDispatcher=request.getRequestDispatcher("/Index.html");
		requestDispatcher.forward(request, response);
		printWriter.print("You are successfully logged out!");

		printWriter.close();
	}
}
