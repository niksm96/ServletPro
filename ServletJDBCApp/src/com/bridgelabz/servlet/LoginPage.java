package com.bridgelabz.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
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
			User userDetails=UserDatabase.loginUser(user);
			if (userDetails!=null) {
				HttpSession session=request.getSession();  
			    session.setAttribute("name",userDetails);  
			    session.setMaxInactiveInterval(30*10);
				Cookie ck=new Cookie("uname", username);
				ck.setMaxAge(30*60);
				response.addCookie(ck);
//				requestDispatcher=request.getRequestDispatcher("/logout.html");
//				requestDispatcher.forward(request, response);
				response.sendRedirect("index.jsp");
			} else {
				requestDispatcher = request.getServletContext().getRequestDispatcher("/Index.html");
				printWriter.println("You are not authorized user, please sign up!");
				requestDispatcher.include(request, response);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		printWriter.println("</div></body></html>");
		printWriter.close();
	}
}
