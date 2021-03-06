package com.conduent.servlet.login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.conduent.servlet.service.UserService;
import com.conduent.servlet.service.impl.UserException;
import com.conduent.servlet.service.impl.UserServiceImpl;
import com.conduent.servlet.user.dto.UserDto;

public class RegisterHttpServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RegisterHttpServlet() {

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		String firstname = req.getParameter("first_name");
		String lastname = req.getParameter("last_name");
		String username = req.getParameter("username");
		String password = req.getParameter("pass");
		
		String[] parameterValues = req.getParameterValues("groups");
		for(String groupnames:parameterValues) {
			System.out.println("group name: "+groupnames);
			
			//opgen = 1
			//group = gs.getGroup(groupnames)
		}
		UserDto dto = new UserDto();
		dto.setFirstName(firstname);
		dto.setLastName(lastname);
		dto.setUsername(username);
		dto.setPassword(password);
		UserService service = new UserServiceImpl();
		boolean addUser = false;
		String message = null;
		try {
			//show error to user when trying to edit the same name
			if (username != null && password != null) {
				String userId = req.getParameter("userId");
				if (userId != null && !"".equals(userId)) {
					dto.setId(Integer.parseInt(userId));
					try {
						addUser = service.updateUser(dto);
						}catch(UserException e) {
							req.setAttribute("errormassage", e.getMessage());
						}
				} else {
					try {
						addUser = service.addUser(dto);
						}catch(UserException e) {
							req.setAttribute("errormassage", e.getMessage());
						}
				}
			}
		} catch (Exception e) {
			message = e.getMessage();
		}
		
		//call saveusergroupmethod
		
		
		HttpSession session = req.getSession(false);
		if(session == null) {
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("hlogin");
			requestDispatcher.forward(req, resp);
		}else {
			if (addUser) {
				RequestDispatcher requestDispatcher = req.getRequestDispatcher("/user");
				requestDispatcher.forward(req, resp);
			} else {
				req.setAttribute("errormessage", message);
				RequestDispatcher requestDispatcher = req.getRequestDispatcher("register.jsp");
				requestDispatcher.forward(req, resp);
			}
		}
	}
	
	private void saveUserGroup(UserDto dto, String[] groupNames) {
		//dto.getId
		
		//for loop for groupnames
		//gs.getGroup(groupname)
		//group.getId();
		//userGroupService.saveUsergroup(userId, groupId);
		
		
	}

}
