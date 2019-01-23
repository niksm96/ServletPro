package com.bridgelabz.servlets;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistrationPage extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response){
		User user = new User();
		user.setFirstName(request.getParameter("firstname"));
		user.setLastName(request.getParameter("lastname"));
		user.setContact(Long.parseLong(request.getParameter("contact")));
		user.setEmailId(request.getParameter("emailid"));
		user.setPassword(request.getParameter("password")); 
		
	}
}
