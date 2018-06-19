package com.conduent.servlet.login;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.conduent.servlet.service.GroupService;
import com.conduent.servlet.service.impl.GroupException;
import com.conduent.servlet.service.impl.GroupServiceImpl;
import com.conduent.servlet.user.dto.GroupDto;

public class GroupServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		GroupService sg = new GroupServiceImpl();
		GroupDto dto = new GroupDto();

		String operation = req.getParameter("operation");
		if (operation != null) {
			String id = req.getParameter("id");
			dto.setId(Integer.parseInt(id));
			if ("delete".equals(operation)) {
				sg.deleteGroup(dto);
			} else if ("edit".equalsIgnoreCase(operation)) {

				req.setAttribute("edit", sg.getGroup(Integer.parseInt(id)));
			}
			req.setAttribute("operation", operation);
		}

		String groupname = req.getParameter("groupname");
		String groupdescription = req.getParameter("groupdescription");
		dto.setGroupname(groupname);
		dto.setGroupdescription(groupdescription);
		

		if (groupname != null && groupdescription != null) {
			String groupId = req.getParameter("groupId");
			if (groupId != null && !"-1".equals(groupId)) {
				dto.setId(Integer.parseInt(groupId));
				try {
				sg.updateGroup(dto);
				}catch(GroupException g) {
					req.setAttribute("errormassage", g.getMessage());
				}
			} else {
				try {
				sg.addGroup(dto);
				}catch(GroupException g) {
					req.setAttribute("errormassage", g.getMessage());
				}
			}
		}

		List<GroupDto> alGroup = sg.getAlGroup();
		alGroup.sort(new GroupIdComparator());
		
		req.setAttribute("groups", alGroup);
		RequestDispatcher requestDispatcher2 = req.getRequestDispatcher("group.jsp");
		requestDispatcher2.forward(req, resp);
	}
}

class GroupIdComparator implements Comparator<GroupDto> {

	@Override
	public int compare(GroupDto o1, GroupDto o2) {
		return Integer.valueOf(o1.getId()).compareTo(o2.getId());
	}
	
}