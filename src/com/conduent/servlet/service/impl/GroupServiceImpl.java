package com.conduent.servlet.service.impl;

import java.util.List;

import com.conduent.servlet.dao.GroupDao;
import com.conduent.servlet.dao.impl.GroupDaoImpl;
import com.conduent.servlet.service.GroupService;
import com.conduent.servlet.user.dto.GroupDto;

public class GroupServiceImpl implements GroupService {

	@Override
	public GroupDto getGroup(String groupName) {
		GroupDao dao = new GroupDaoImpl();
		return dao.getGroup(groupName);
	}

	@Override
	public boolean addGroup(GroupDto dto) {
		GroupDao dao = new GroupDaoImpl();

		// check any group with the given name
		GroupDto existingGroup = dao.getGroup(dto.getGroupname());
		if (existingGroup != null) {
			// TODo change to user defined exception eg: GroupException
		
				throw new GroupException(
						"Already group is available with the given group name:" + dto.getGroupname());
		
		}

		boolean addGroup = dao.addGroup(dto);
		return addGroup;
	}

	@Override
	public List<GroupDto> getAlGroup() {
		GroupDao dao = new GroupDaoImpl();
		List<GroupDto> alGroup = dao.getAlGroups();
		return alGroup;
	}

	@Override
	public boolean deleteGroup(GroupDto dto) {
		GroupDao dao = new GroupDaoImpl();
		boolean deleteGroup = dao.deleteGroup(dto);
		return deleteGroup;
	}

	@Override
	public GroupDto getGroup(int id) {
		GroupDao dao=new GroupDaoImpl();
		return dao.getGroup(id);
	}

	@Override
	public boolean updateGroup(GroupDto dto) {
		GroupDao dao = new GroupDaoImpl();

		// check any group with the given name
		GroupDto existingGroup = dao.getGroup(dto.getGroupname());
		if (existingGroup != null && existingGroup.getId()!=dto.getId()) {
			// TODo change to user defined exception eg: GroupException
				throw new GroupException(
						"Already group is available with the given group name:" + dto.getGroupname());
			
		}

		return dao.updateGroup(dto);
	}

}
