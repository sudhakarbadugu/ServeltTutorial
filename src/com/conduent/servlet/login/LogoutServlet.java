package com.conduent.servlet.login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("User is logging out: "+ getServletContext().getAttribute("username"));
		getServletContext().removeAttribute("username");
		
		HttpSession session = req.getSession(false);
		if(session != null) {
			session.invalidate();
		}
		// Set standard HTTP/1.1 no-cache headers.
		resp.setHeader("Cache-Control", "private, no-store, no-cache, must-revalidate");

		// Set standard HTTP/1.0 no-cache header.
		resp.setHeader("Pragma", "no-cache");
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("hlogin");
		requestDispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
