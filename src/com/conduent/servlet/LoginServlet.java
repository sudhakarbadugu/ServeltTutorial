package com.conduent.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		System.out.println("User is logged in");
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		service(request, response);
	}

	public void service(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		String method = request.getMethod();

		if ("Get".equalsIgnoreCase(method)) {
			doGet(request, resp);
		} else {
			doPost(request, resp);
		}
	}

	public void doGet(HttpServletRequest request, HttpServletResponse resp) throws IOException {
		resp.sendError(405, "HTTP method GET is not supported by this URL");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse resp) throws IOException {
		PrintWriter writer = resp.getWriter();
		writer.println("Welcome to hdfc bank Sudhakar");
	}

}
