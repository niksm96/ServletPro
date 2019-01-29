package com.bridgelabz.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class EditServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(false);
		RequestDispatcher requestDispatcher=null;
		if(session!=null) {
			requestDispatcher=request.getRequestDispatcher("/edit.jsp");
			requestDispatcher.forward(request, response);
		}
		else {
			response.sendRedirect("Index.html");
		}
	}
}
