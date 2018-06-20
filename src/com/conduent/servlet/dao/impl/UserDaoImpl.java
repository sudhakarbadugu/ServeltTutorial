package com.conduent.servlet.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.conduent.servlet.dao.UserDao;
import com.conduent.servlet.db.utils.DatatbaseUtility;
import com.conduent.servlet.user.dto.UserDto;

public class UserDaoImpl implements UserDao {
	String SELECT_QUERY = "select * from T_USER where username = ? and password = ?";
	String SELECTALL_QUERY = "select * from T_USER";
	String SELECT_QUERY_BASED_ON_USERNAME = "select * from T_USER where username=?";
	String SELECT_QUERY_BASED_ON_ID = "select * from T_USER where id=?";
	String INSERT_QUERY = "INSERT INTO T_USER (FIRST_NAME, LAST_NAME, USERNAME, PASSWORD, CREATED_DATE) VALUES (?,?,?,?,?)";
	
	//modify the query to include all fields. and change where condition based on id.
	String UPDATE_QUERY = "update T_User set password=? where username=?";
	String DELETE_QUERY = "DELETE FROM T_USER WHERE ID=?";

	List<UserDto> list = new ArrayList<UserDto>();

	@Override
	public UserDto getUser(String username, String password) {
		UserDto dto = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DatatbaseUtility.getConnection();
			pstmt = con.prepareStatement(SELECT_QUERY);
			pstmt.setString(1, username);
			pstmt.setString(2, password);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				dto = new UserDto();
				String firstname = rs.getString("first_name");
				String lastname = rs.getString("last_name");
				String username1 = rs.getString("username");
				String password1 = rs.getString("password");

				dto.setUsername(username1);
				dto.setPassword(password1);
				dto.setFirstName(firstname);
				dto.setLastName(lastname);
				// list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DatatbaseUtility.closeResultSet(rs);
			DatatbaseUtility.closePreparedStmt(pstmt);
			DatatbaseUtility.closeConnection(con);
		}
		return dto;
	}

	@Override
	public List<UserDto> getAlUser() {
		UserDto dto = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DatatbaseUtility.getConnection();
			pstmt = con.prepareStatement(SELECTALL_QUERY);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				dto = new UserDto();
				int id = rs.getInt(1);
				String firstname = rs.getString(2);
				String lastname = rs.getString(3);
				String username = rs.getString(4);
				String password = rs.getString(5);
				Date creationdate = rs.getDate(6);

				dto.setId(id);
				dto.setFirstName(firstname);
				dto.setLastName(lastname);
				dto.setUsername(username);
				dto.setPassword(password);
				dto.setCreationdate(creationdate);
				list.add(dto);

			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			DatatbaseUtility.closeResultSet(rs);
			DatatbaseUtility.closePreparedStmt(pstmt);
			DatatbaseUtility.closeConnection(con);
		}

		return list;
	}

	@Override
	public boolean insertUser(UserDto dto) {
		boolean isinserted = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DatatbaseUtility.getConnection();
			pstmt = con.prepareStatement(INSERT_QUERY);
			String firstName = dto.getFirstName();
			String lastName = dto.getLastName();

			String username = dto.getUsername();
			String password = dto.getPassword();

			pstmt.setString(1, firstName);
			pstmt.setString(2, lastName);
			pstmt.setString(3, username);
			pstmt.setString(4, password);
			pstmt.setDate(5, new Date(System.currentTimeMillis()));

			int result = pstmt.executeUpdate();
			isinserted = result != 0;
		} catch (Exception e) {
			e.printStackTrace();
			// throw userdefined exception
			// ObjectExistException
		} finally {
			DatatbaseUtility.closePreparedStmt(pstmt);
			DatatbaseUtility.closeConnection(con);
		}
		return isinserted;
	}

	@Override
	public boolean updateUser(UserDto dto) {
		boolean userupdated = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DatatbaseUtility.getConnection();
			pstmt = con.prepareStatement(UPDATE_QUERY);
			String password = dto.getPassword();
			String username = dto.getUsername();
			pstmt.setString(1, password);
			pstmt.setString(2, username);
			int result = pstmt.executeUpdate();
			userupdated = result != 0;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DatatbaseUtility.closePreparedStmt(pstmt);
			DatatbaseUtility.closeConnection(con);
		}
		return userupdated;
	}

	@Override
	public boolean deleteUser(UserDto dto) {
		boolean userdeleted = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DatatbaseUtility.getConnection();
			pstmt = con.prepareStatement(DELETE_QUERY);
			int id = dto.getId();
			pstmt.setInt(1, id);
			int result = pstmt.executeUpdate();
			userdeleted = result != 0;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DatatbaseUtility.closePreparedStmt(pstmt);
			DatatbaseUtility.closeConnection(con);
		}
		return userdeleted;
	}

	@Override
	public UserDto getUser(String username) {
		UserDto dto = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DatatbaseUtility.getConnection();
			pstmt = con.prepareStatement(SELECT_QUERY_BASED_ON_USERNAME);
			pstmt.setString(1, username);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				dto = new UserDto();
				int id = rs.getInt(1);
				String firstName = rs.getString(2);
				String lastName = rs.getString(3);
				String username1 = rs.getString(4);
				String password = rs.getString(5);
				Date date = rs.getDate(6);
				dto.setId(id);
				dto.setFirstName(firstName);
				dto.setLastName(lastName);
				dto.setUsername(username1);
				dto.setPassword(password);
				dto.setCreationdate(date);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DatatbaseUtility.closeResultSet(rs);
			DatatbaseUtility.closePreparedStmt(pstmt);
			DatatbaseUtility.closeConnection(con);
		}
		return dto;
	}

	@Override
	public UserDto getUser(Integer id) {
		UserDto dto = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DatatbaseUtility.getConnection();
			pstmt = con.prepareStatement(SELECT_QUERY_BASED_ON_ID);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				dto = new UserDto();
				int id1 = rs.getInt(1);
				String firstName = rs.getString(2);
				String lastName = rs.getString(3);
				String username1 = rs.getString(4);
				String password = rs.getString(5);
				Date date = rs.getDate(6);
				dto.setId(id1);
				dto.setFirstName(firstName);
				dto.setLastName(lastName);
				dto.setUsername(username1);
				dto.setPassword(password);
				dto.setCreationdate(date);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DatatbaseUtility.closeResultSet(rs);
			DatatbaseUtility.closePreparedStmt(pstmt);
			DatatbaseUtility.closeConnection(con);
		}
		return dto;
	}

}
