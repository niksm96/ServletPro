package com.bridgelabz.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bridgelabz.dbutil.UserDatabase;
import com.bridgelabz.model.User;

public class LoginPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user=new User();
		user.setEmailId(username);
		user.setPassword(password);
		response.setContentType("text/html");
		PrintWriter printWriter = response.getWriter();
		printWriter.write("<html><body><div id='serlvetResponse' style='text-align:center;'>");
		RequestDispatcher requestDispatcher = null;
		try {
			boolean result=UserDatabase.loginUser(user);
			if (result) {
				HttpSession session=request.getSession();  
			    session.setAttribute("name",username);  
				requestDispatcher=request.getRequestDispatcher("/logout.html");
				requestDispatcher.forward(request, response);
			} else {
				printWriter.println("You are not authorized user, please sign up!");
				requestDispatcher = request.getRequestDispatcher("/Index.html");
				requestDispatcher.include(request, response);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		printWriter.println("</div></body></html>");
		printWriter.close();
	}
}
