package com.bridgelabz.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//		response.setContentType("text/html");
//		PrintWriter printWriter = response.getWriter();
//		HttpSession session = request.getSession(false);
//		session.invalidate();

//		RequestDispatcher requestDispatcher=request.getRequestDispatcher("/Index.html");
//		requestDispatcher.forward(request, response);
//		printWriter.print("<form action=\"logout\">\n");
//		printWriter.print("<button type=\"submit\" value=\"logout\">Logout</button>\n" + 
//				"</form>");
//		response.sendRedirect("Index.html");
//		printWriter.close();

		response.setContentType("text/html");
		Cookie loginCookie = null;
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("uname")|| cookie.getName().equals("JSESSIONID")) {
					cookie.setMaxAge(0);
					cookie.setValue(null);
					response.addCookie(cookie);
				}
			}
		}
//
//		if (loginCookie != null) {
//			loginCookie.setMaxAge(0);
//			response.addCookie(loginCookie);
//		}
		HttpSession session = request.getSession(false);
//    	System.out.println("User="+session.getAttribute("name"));
    	if(session != null){
    		session.removeAttribute("name");
    		session.invalidate();
    		response.sendRedirect("index.jsp");
    	}
	}
}
