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
	static final String REGEX_CONTACT = "x{10}";
	
	@Override
	public void init(FilterConfig arg0) throws ServletException {}

	

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		RequestDispatcher requestDispatcher=null;
		HttpServletResponse response=(HttpServletResponse)arg1;
		PrintWriter printWriter = response.getWriter();
		printWriter.println("<html><body>");
		HttpServletRequest request=(HttpServletRequest) arg0;
		String emailid=request.getParameter("username");
		String password=request.getParameter("password");
		
		
	}
	@Override
	public void destroy() {}
	

}
