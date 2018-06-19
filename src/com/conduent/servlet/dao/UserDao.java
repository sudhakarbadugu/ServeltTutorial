package com.conduent.servlet.dao;

import java.util.List;

import com.conduent.servlet.user.dto.UserDto;

public interface UserDao {

	UserDto getUser(String username, String password);

	List<UserDto> getAlUser();

	boolean insertUser(UserDto dto);
	UserDto getUser(String username);
	UserDto getUser(Integer id);

	boolean updateUser(UserDto dto);

	boolean deleteUser(UserDto dto);
}
