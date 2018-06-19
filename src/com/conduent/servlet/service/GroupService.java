package com.conduent.servlet.service;

import java.util.List;

import com.conduent.servlet.user.dto.GroupDto;

public interface GroupService {
	GroupDto getGroup(String groupname);
	
	GroupDto getGroup(int id);

	boolean addGroup(GroupDto dto);
	
	boolean updateGroup(GroupDto dto);

	List<GroupDto> getAlGroup();

	boolean deleteGroup(GroupDto dto);
	


}
