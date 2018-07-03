package com.conduent.servlet.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OpgenServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
	
		if (req.getAttribute("downloaded opgen") != null) {
			out.println("opgen File is downloaded successfully");
		}
		RequestDispatcher requestDispatcher2 = req.getRequestDispatcher("opgen.jsp");
		requestDispatcher2.forward(req, resp);
		
	}
}
