package com.conduent.servlet.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class OpgenServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		Object username = session.getAttribute("username");
		req.setAttribute("username", username);

		RequestDispatcher requestDispatcher = req.getRequestDispatcher("p-header.jsp");
		requestDispatcher.include(req, resp);

		if("admin".equals(username)) {
			RequestDispatcher requestDispatcher2 = req.getRequestDispatcher("admin.html");
			requestDispatcher2.include(req, resp);
		}
		
		RequestDispatcher requestDispatcher2 = req.getRequestDispatcher("opgen.html");
		requestDispatcher2.include(req, resp);

		PrintWriter out = resp.getWriter();
		if (req.getAttribute("downloaded opgen") != null) {
			out.println("opgen File is downloaded successfully");
		}
		RequestDispatcher requestDispatcher3 = req.getRequestDispatcher("footer.html");
		requestDispatcher3.include(req, resp);
	}
}
