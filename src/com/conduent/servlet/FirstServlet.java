package com.conduent.servlet;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;

public class FirstServlet implements Servlet{

	@Override
	public void destroy() {
		System.out.println("Destroy");
	}

	@Override
	public ServletConfig getServletConfig() {
		System.out.println("servelt config");
		return null;
	}

	@Override
	public String getServletInfo() {
		System.out.println("servelt info");
		return null;
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		System.out.println("Init");
		
	}

	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		System.out.println("service");
		
		PrintWriter writer = resp.getWriter();
		writer.println("<h1>Welcome to Sevlets</h1>");
		writer.println("<h1>Welcome to 2nd</h1>");
		
		
	}

}
