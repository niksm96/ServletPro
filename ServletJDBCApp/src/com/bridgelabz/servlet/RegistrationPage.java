package com.bridgelabz.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bridgelabz.dbutil.UserDatabase;
import com.bridgelabz.model.User;

public class RegistrationPage extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = new User();
		PrintWriter printWriter = response.getWriter();
		RequestDispatcher requestDispatcher=null;
		printWriter.println("<html><body>");
		String firstName = request.getParameter("firstname");
		user.setFirstName(firstName);
		String lastName = request.getParameter("lastname");
		user.setLastName(lastName);
		String contact = request.getParameter("contact");
		user.setContact(Long.parseLong(contact));
		String emailId = request.getParameter("emailid");
		user.setEmailId(emailId);
		String password = request.getParameter("password");
		user.setPassword(password);
		if ("".equals(emailId) || "".equals(password)) {
			requestDispatcher = request.getRequestDispatcher("/Index2.html");
			requestDispatcher.include(request, response);
			printWriter.println("Please fill email and password properly!");
		} else {
			try {
				UserDatabase.registerUser(user);
			} catch (Exception e) {
				e.printStackTrace();
			}
			requestDispatcher=request.getRequestDispatcher("/Index.html");
			requestDispatcher.forward(request, response);
			printWriter.println("You have registered. Log in!");
		}
		printWriter.println("</html></body>");
		printWriter.close();
	}
}
