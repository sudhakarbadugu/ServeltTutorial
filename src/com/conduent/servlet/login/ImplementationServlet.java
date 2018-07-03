package com.conduent.servlet.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ImplementationServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		HttpSession session = req.getSession(false);

		Object username = session.getAttribute("username");
		req.setAttribute("username", username);

		if (req.getAttribute("downloaded impl") != null) {
			out.println("impl File is downloaded successfully");
		}
		RequestDispatcher requestDispatcher2 = req.getRequestDispatcher("implementaion.jsp");
		requestDispatcher2.forward(req, resp);
		
	}
}
