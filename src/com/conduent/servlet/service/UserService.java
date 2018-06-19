package com.conduent.servlet.service;

import java.util.List;

import com.conduent.servlet.user.dto.UserDto;

public interface UserService {
	UserDto getUser(String username, String password);
	
	boolean isUserExist(String username, String password);
	
	boolean addUser(UserDto dto);
	UserDto getUser(String username);
	UserDto getUser(Integer id);
	
	List<UserDto> getAlUser();
	
	boolean updateUser(UserDto dto);
	
	boolean deleteUser(UserDto dto);
}
