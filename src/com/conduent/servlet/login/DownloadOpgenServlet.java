package com.conduent.servlet.login;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownloadOpgenServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Enumeration<String> parameterNames = req.getParameterNames();
		while(parameterNames.hasMoreElements()) {
			String nextElement = parameterNames.nextElement();
			System.out.println("Download opgen Servlet: "+ nextElement);
		}

		
		req.setAttribute("downloaded opgen", true);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/opgenServlet");
		requestDispatcher.forward(req, resp);
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
