package com.conduent.filter;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.conduent.servlet.service.UserService;
import com.conduent.servlet.service.impl.UserServiceImpl;
import com.conduent.servlet.user.dto.UserDto;

/**
 * Servlet Filter implementation class AuthenticationFilter
 */
public class AuthenticationFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public AuthenticationFilter() {
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		System.out.println("Auth destroy");
	}

	private List<String> ignoreFilesList = Arrays.asList("/register.jsp");
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("Auth dofilter ");

		// check session is there are not
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		HttpSession session2 = request.getSession(false);
		// Set standard HTTP/1.1 no-cache headers.
		response.setHeader("Cache-Control", "private, no-store, no-cache, must-revalidate");

		// Set standard HTTP/1.0 no-cache header.
		response.setHeader("Pragma", "no-cache");
		if (session2 != null) {
			System.out.println("Session is alread available and skipping login");
			chain.doFilter(req, resp);
		} else {
			String username = req.getParameter("username");
			String password = req.getParameter("pass");
			String group = req.getParameter("group");

			// Write logic check whether user is there or not
			UserDto dto = new UserDto();
			dto.setUsername(username);
			dto.setPassword(password);

			UserService service = new UserServiceImpl();
			
			String servletPath = request.getServletPath();
			if(ignoreFilesList.contains(servletPath)) {
				chain.doFilter(req, resp);
				return;
			}
			if (Objects.nonNull(username) && Objects.nonNull(password) && service.isUserExist(username, password)) {
				System.out.println("Creatig the Session");
				HttpSession session = request.getSession();
				session.setAttribute("username", username);
				session.setMaxInactiveInterval(60 * 15);

				session.setAttribute("username", username);
				req.setAttribute("group", group);

				chain.doFilter(req, resp);
			} else {
				System.out.println("Session is not avaiable, forwarding request to login page");
				if (username != null || password != null) {
					req.setAttribute("errorMessage", "Requested credentials are wrong");
				}
				RequestDispatcher requestDispatcher1 = req.getRequestDispatcher("login.jsp");
				requestDispatcher1.include(req, resp);
			}
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("Auth init");
	}

}
