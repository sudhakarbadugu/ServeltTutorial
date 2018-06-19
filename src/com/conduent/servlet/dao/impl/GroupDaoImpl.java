package com.conduent.servlet.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.conduent.servlet.dao.GroupDao;
import com.conduent.servlet.db.utils.DatatbaseUtility;
import com.conduent.servlet.user.dto.GroupDto;

public class GroupDaoImpl implements GroupDao{
	String INSERT_QUERY="INSERT INTO T_GROUP (GROUP_NAME,GROUP_DESCRIPTION) VALUES(?,?)";
	String SELECT_QUERY="SELECT * FROM T_GROUP";
	String SELECT_BASED_ON_ID_QUERY="SELECT * FROM T_GROUP WHERE ID = ?";
	String SELECT_BASED_ON_NAME_QUERY="SELECT * FROM T_GROUP WHERE group_name = ?";
	String DELETE_QUERY="DELETE FROM T_GROUP WHERE ID=?";
	String UPDATE_QUERY="UPDATE T_GROUP SET GROUP_NAME=?, GROUP_DESCRIPTION = ? WHERE ID=?";
	
	List<GroupDto> list=new ArrayList<GroupDto>();
	@Override
	public GroupDto getGroup(String groupname) {
		GroupDto dto=null;
		PreparedStatement pstmt = null;
		Connection con = null;
		ResultSet rs = null;
		try {
			 con = DatatbaseUtility.getConnection();
			 pstmt = con.prepareStatement(SELECT_BASED_ON_NAME_QUERY);
			 pstmt.setString(1, groupname);
			 rs = pstmt.executeQuery();
			 while(rs.next()) {
				 dto=new GroupDto();
				 int id = rs.getInt(1);
				 String groupName = rs.getString(2);
				 String groupdescription = rs.getString(3);
				 dto.setId(id);
				 dto.setGroupname(groupName);
				 dto.setGroupdescription(groupdescription);
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

	@Override
	public List<GroupDto> getAlGroups() {
		GroupDto dto=null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			  con = DatatbaseUtility.getConnection();
			  pstmt = con.prepareStatement(SELECT_QUERY);
			    rs = pstmt.executeQuery();
			  while(rs.next()) {
				  dto=new GroupDto();
				  int id = rs.getInt(1);
				  String groupname = rs.getString(2);
				  String groupdescription = rs.getString(3);
				  dto.setId(id);
				  dto.setGroupname(groupname);
				  dto.setGroupdescription(groupdescription);
				  list.add(dto);
			  }
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DatatbaseUtility.closeResultSet(rs);
			DatatbaseUtility.closePreparedStmt(pstmt);
			DatatbaseUtility.closeConnection(con);
		}
		return list;
	}

	@Override
	public boolean addGroup(GroupDto dto) {
		
		boolean groupadded=false;
		Connection con = null;
		PreparedStatement pstmt= null;
		try {
			  con = DatatbaseUtility.getConnection();
			pstmt = con.prepareStatement(INSERT_QUERY);
			String groupname = dto.getGroupname();
			String groupdescription = dto.getGroupdescription();
			pstmt.setString(1, groupname);
			pstmt.setString(2, groupdescription);
			int result = pstmt.executeUpdate();
			groupadded = result != 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DatatbaseUtility.closePreparedStmt(pstmt);
			DatatbaseUtility.closeConnection(con);
		}
		return groupadded;
	}

	@Override
	public boolean deleteGroup(GroupDto dto) {
		boolean groupdeleted=false;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			  con = DatatbaseUtility.getConnection();
			  pstmt = con.prepareStatement(DELETE_QUERY);
			int id = dto.getId();
			pstmt.setInt(1, id);
			int result = pstmt.executeUpdate();
			groupdeleted = result !=0;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DatatbaseUtility.closePreparedStmt(pstmt);
			DatatbaseUtility.closeConnection(con);
		}
		return groupdeleted;
	}

	@Override
	public boolean updateGroup(GroupDto dto) {
		boolean isGroupUpdated=false;
		Connection con = null;
		PreparedStatement pstmt= null;
		try {
			  con = DatatbaseUtility.getConnection();
			pstmt = con.prepareStatement(UPDATE_QUERY);
			pstmt.setString(1, dto.getGroupname());
			pstmt.setString(2, dto.getGroupdescription());
			pstmt.setInt(3, dto.getId());
			int result = pstmt.executeUpdate();
			isGroupUpdated = result != 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DatatbaseUtility.closePreparedStmt(pstmt);
			DatatbaseUtility.closeConnection(con);
		}
		return isGroupUpdated;
	}

	@Override
	public GroupDto getGroup(Integer id) {
		ResultSet rs = null;
		GroupDto dto= null;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			  con = DatatbaseUtility.getConnection();
			  pstmt = con.prepareStatement(SELECT_BASED_ON_ID_QUERY);
			  pstmt.setInt(1, id);
			  rs = pstmt.executeQuery();
			  while(rs.next()) {
				  dto = new GroupDto();
				  int id1 = rs.getInt(1);
				  String groupName = rs.getString(2);
				  String groupdescription = rs.getString(3);
				  dto.setId(id1);
				  dto.setGroupname(groupName);
				  dto.setGroupdescription(groupdescription);
			  }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dto;
	}

}
