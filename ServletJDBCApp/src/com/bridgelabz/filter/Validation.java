package com.bridgelabz.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Validation implements Filter {
	 static final String REGEX_EMAIL_ID = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\\\.[A-Z]{2,6}$";
	 static final String REGEX_PASSWORD = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
	 static final String REGEX_CONTACT = "^((\\+){1}91){1}[1-9]{1}[0-9]{9}$";
	
	@Override
	public void init(FilterConfig arg0) throws ServletException {}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chainObj)
			throws IOException, ServletException {
		RequestDispatcher requestDispatcher=null;
		HttpServletResponse response=(HttpServletResponse)res;
		PrintWriter printWriter = response.getWriter();
		printWriter.println("<html><body>");
		HttpServletRequest request=(HttpServletRequest) req;
		String emailid=request.getParameter("emailid");
		String password=request.getParameter("password");
		String contact=request.getParameter("contact");
		if(emailid.matches(REGEX_EMAIL_ID) && (password.matches(REGEX_PASSWORD))&& (contact.matches(REGEX_CONTACT))) {
			chainObj.doFilter(request, response);
		}
		else {
			printWriter.println("Username or password or contact is invalid!");
			requestDispatcher=request.getRequestDispatcher("/Index2.html");
			requestDispatcher.include(request, response);
		}
		printWriter.println("</html></body>");
		printWriter.close();
	}
	
	@Override
	public void destroy() {}
	

}
