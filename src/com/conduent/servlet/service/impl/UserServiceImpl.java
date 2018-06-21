package com.conduent.servlet.service.impl;

import java.util.List;

import com.conduent.servlet.dao.UserDao;
import com.conduent.servlet.dao.impl.UserDaoImpl;
import com.conduent.servlet.service.UserService;
import com.conduent.servlet.user.dto.UserDto;

public class UserServiceImpl implements UserService {

	@Override
	public UserDto getUser(String username, String password) {
		UserDao dao = new UserDaoImpl();

		UserDto user = dao.getUser(username, password);
		return user;
	}

	@Override
	public boolean isUserExist(String username, String password) {
		UserDao dao = new UserDaoImpl();

		UserDto user = dao.getUser(username, password);
		return user != null;
	}

	@Override
	public boolean addUser(UserDto dto) {
		UserDao dao = new UserDaoImpl();
		UserDto existingUser = dao.getUser(dto.getUsername());
		if(existingUser!=null) {
			throw new UserException("user already exist with given username: "+dto.getUsername());
		}

		boolean user = dao.insertUser(dto);
		return user;
	}

	@Override
	public List<UserDto> getAlUser() {
		UserDao dao = new UserDaoImpl();

		List<UserDto> alUser = dao.getAlUser();
		return alUser;
	}

	@Override
	public boolean updateUser(UserDto dto) {
		UserDao dao = new UserDaoImpl();
		UserDto existingUser = dao.getUser(dto.getUsername());
		if(existingUser!=null && existingUser.getId() != dto.getId()) {
			throw new UserException("user already exist with given username: "+dto.getUsername());
		}
		boolean updateUser = dao.updateUser(dto);
		return updateUser;
	}

	@Override
	public boolean deleteUser(UserDto dto) {
		UserDao dao = new UserDaoImpl();
		boolean deleteUser = dao.deleteUser(dto);
		return deleteUser;
	}

	@Override
	public UserDto getUser(String username) {
		UserDao dao= new UserDaoImpl();
		return dao.getUser(username);
	}

	@Override
	public UserDto getUser(Integer id) {
		UserDao dao=new UserDaoImpl();
		return dao.getUser(id);
	}

}
