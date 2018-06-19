package com.conduent.servlet.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class WelcomeServlet
 */
public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WelcomeServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		printContextParams();
		PrintWriter writer = response.getWriter();
		response.setContentType("text/html");
		
		HttpSession session = request.getSession(false);
		
		String username = (String)session.getAttribute("username");
		
		//get this value from database.
		String groupName = (String)request.getAttribute("group");
		if("admin".equals(username)) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("p-header.jsp");
			requestDispatcher.include(request, response);

			RequestDispatcher requestDispatcher1 = request.getRequestDispatcher("admin.html");
			requestDispatcher1.include(request, response);
			
			RequestDispatcher requestDispatcher2 = request.getRequestDispatcher("footer.html");
			requestDispatcher2.include(request, response);
			
		}
		else if("staging".equalsIgnoreCase(groupName)) {
			//staging
			RequestDispatcher rd = request.getRequestDispatcher("/stagingServlet");
			rd.forward(request, response);
		}
		else if("Opgen".equalsIgnoreCase(groupName)) {
			//staging
			request.setAttribute("username", username);
			RequestDispatcher rd = request.getRequestDispatcher("/opgenServlet");
			rd.forward(request, response);
		}
		else if("implementation".equalsIgnoreCase(groupName)) {
			//staging
			RequestDispatcher rd = request.getRequestDispatcher("/implServlet");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	
	private void printContextParams() {
		//1st approch
		ServletContext servletContext = getServletConfig().getServletContext();
//		Enumeration<String> initParameterNames = servletContext.getInitParameterNames();
		
		//2nd approch
		Enumeration<String> initParameterNames = getInitParameterNames();
		while(initParameterNames.hasMoreElements()) {
			String nextElement = initParameterNames.nextElement();
			System.out.println("Context param name: " + nextElement + " Value "+ servletContext.getInitParameter(nextElement));
		}
		
	}
}
