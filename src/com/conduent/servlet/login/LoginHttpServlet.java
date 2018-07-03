package com.conduent.servlet.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.conduent.servlet.db.utils.DatatbaseUtility;
import com.conduent.servlet.service.UserService;
import com.conduent.servlet.service.impl.UserServiceImpl;
import com.conduent.servlet.user.dto.UserDto;

public class LoginHttpServlet extends HttpServlet {

	public LoginHttpServlet() {
		System.out.println("LoginHttpSevlet constructor");
	}

	@Override
	public void init() throws ServletException {
		System.out.println("LoginHttpSErvlet custom init");
		Properties p = new Properties();
		try {
			p.load(getServletContext().getResourceAsStream("/WEB-INF/properties/jdbc.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		DatatbaseUtility.setProperties(p);

	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		if(session != null) {
			String username = req.getParameter("username");
			String group = req.getParameter("group");
			
			req.setAttribute("username", username);
			req.setAttribute("group", group);
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("pwelcome");
			requestDispatcher.forward(req, resp);
		}else {
			RequestDispatcher requestDispatcher1 = req.getRequestDispatcher("login.jsp");
			requestDispatcher1.include(req, resp);
		}
	}

	private void doLogin(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		PrintWriter writer = resp.getWriter();
		String username = req.getParameter("username");
		String password = req.getParameter("pass");
		String group = req.getParameter("group");

		// Write logic check whether user is there or not
		UserDto dto = new UserDto();
		dto.setUsername(username);
		dto.setPassword(password);

		UserService service = new UserServiceImpl();

		if (service.isUserExist(username, password)) {
			HttpSession session = req.getSession();
			session.setAttribute("username", username);
			// session.setMaxInactiveInterval(60);

			req.setAttribute("username", username);
			req.setAttribute("group", group);
			ServletContext application = getServletContext();
			application.setAttribute("username", username);
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("pwelcome");
			requestDispatcher.forward(req, resp);
		} else {
			if (username != null || password != null) {
				req.setAttribute("Errormessage", "Requested credentials are wrong");
			}
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("header.jsp");
			requestDispatcher.include(req, resp);

			RequestDispatcher requestDispatcher1 = req.getRequestDispatcher("hlogin.jsp");
			requestDispatcher1.include(req, resp);

			RequestDispatcher requestDispatcher2 = req.getRequestDispatcher("footer.html");
			requestDispatcher2.include(req, resp);
		}

	}
}
