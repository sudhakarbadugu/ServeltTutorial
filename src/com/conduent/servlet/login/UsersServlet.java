package com.conduent.servlet.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.conduent.servlet.service.GroupService;
import com.conduent.servlet.service.UserService;
import com.conduent.servlet.service.impl.GroupException;
import com.conduent.servlet.service.impl.GroupServiceImpl;
import com.conduent.servlet.service.impl.UserServiceImpl;
import com.conduent.servlet.user.dto.GroupDto;
import com.conduent.servlet.user.dto.UserDto;

public class UsersServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserService users = new UserServiceImpl();
		UserDto dto = new UserDto();
		GroupService groupService = new GroupServiceImpl();
		List<GroupDto> groups = groupService.getAlGroup();
		req.setAttribute("groups", groups);
		
		String operation = req.getParameter("operation");
		if (operation != null) {
			String id = req.getParameter("id");

			dto.setId(Integer.parseInt(id));
			if ("delete".equals(operation))
				users.deleteUser(dto);
			else if("edit".equalsIgnoreCase(operation)) {
				
				
				req.setAttribute("userDto", users.getUser(Integer.parseInt(id)));
				req.setAttribute("operation", operation);
				RequestDispatcher requestDispatcher = req.getRequestDispatcher("register.jsp");
				requestDispatcher.forward(req, resp);
				return;
			}
		}
		
		resp.setContentType("text/html");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		dto.setPassword(password);
		dto.setUsername(username);

		List<UserDto> alUser = users.getAlUser();
		alUser.sort(new UserIdComparator());
		req.setAttribute("users", alUser);
		
		RequestDispatcher requestDispatcher1 = req.getRequestDispatcher("users.jsp");
		requestDispatcher1.forward(req, resp);
	}
	
	public static String getValue() {
		return "new config";
	}
}
class UserIdComparator implements Comparator<UserDto>{

	@Override
	public int compare(UserDto o1, UserDto o2) {
		return Integer.valueOf(o1.getId()).compareTo(o2.getId());
	}
}