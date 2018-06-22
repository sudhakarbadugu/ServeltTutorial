package com.conduent.servlet.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class StagingServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// usingHiddenFormFields(req, resp);
		// usingCookies(req, resp);
		// usingURLRewriting(req, resp);

		HttpSession session = req.getSession(false);
		Object username = session.getAttribute("username");
		req.setAttribute("username", username);

		includeHeaderAndStagingContent(req, resp);

	}

	private void usingURLRewriting(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		PrintWriter out = resp.getWriter();
		String username = (String) req.getAttribute("username");

		if (username == null) {
			// Get username cookie value from request
			username = req.getParameter("username");
			req.setAttribute("username", username);
		}

		includeHeaderAndStagingContent(req, resp);

		out.print("<a href='stagingServlet?username=" + username + "' class='btn btn-primary'>Using URL</a>");
	}

	private void usingCookies(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		PrintWriter out = resp.getWriter();

		String username = (String) req.getAttribute("username");

		if (username == null) {
			// Get username cookie value from request
			Cookie[] cookies = req.getCookies();
			if (cookies != null) {
				for (Cookie c : cookies) {
					String name = c.getName();
					if ("username".equals(name)) {
						username = c.getValue();
					}
				}
			}
			req.setAttribute("username", username);
		}

		Cookie cookie = new Cookie("username", username);
		cookie.setMaxAge(0); // delete a cookie
		resp.addCookie(cookie);

		includeHeaderAndStagingContent(req, resp);

		// Session tracking using cookies
		out.print("<form action='stagingServlet'>");
		out.print("<input type='checkbox' name='file1' value='report1'> Report1");
		out.print("<input type='submit' value='Using Cookies'>");
		out.print("</form>");
	}

	private PrintWriter usingHiddenFormFields(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// get the attribute
		String username = (String) req.getAttribute("username");

		if (username == null) {
			username = req.getParameter("username");
			req.setAttribute("username", username);
		}

		PrintWriter out = includeHeaderAndStagingContent(req, resp);

		// Session tracking using hidden form
		out.print("<form action='stagingServlet'>");
		out.print("<input type='checkbox' name='file1' value='report1'> Report1");
		out.print("<input type='hidden' name='username' value='" + username + "'>");
		out.print("<input type='submit' value='Using hidden form field'>");
		out.print("</form>");
		return out;
	}

	private PrintWriter includeHeaderAndStagingContent(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		

		//include admin page here if only user is admin
		HttpSession session = req.getSession(false);
		Object username = session.getAttribute("username");
		req.setAttribute("username", username);
		
		if("admin".equals(username)) {
			RequestDispatcher requestDispatcher2 = req.getRequestDispatcher("admin.html");
			requestDispatcher2.include(req, resp);
		}
		
		

		if (req.getAttribute("downloaded") != null) {
			out.println("File is downloaded successfully");
		}

		if (req.getAttribute("uploadStatus") != null) {
			out.println(req.getAttribute("uploadStatus"));
		}
		RequestDispatcher requestDispatcher1 = req.getRequestDispatcher("staging.jsp");
		requestDispatcher1.forward(req, resp);

	

		return out;
	}
}
