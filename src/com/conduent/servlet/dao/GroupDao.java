package com.conduent.servlet.dao;

import java.util.List;

import com.conduent.servlet.user.dto.GroupDto;

public interface GroupDao {
	GroupDto getGroup(String groupname);

	GroupDto getGroup(Integer id);

	List<GroupDto> getAlGroups();

	boolean addGroup(GroupDto dto);
	
	boolean updateGroup(GroupDto dto);

	boolean deleteGroup(GroupDto dto);

}
