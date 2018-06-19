package com.conduent.servlet.db.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Properties;

public class DatatbaseUtility {

	static Properties p = null;
	private DatatbaseUtility() {

	}
	
	public static void setProperties(Properties properties) {
		if(Objects.isNull(p)) {
			p = properties;
		}
	}
	

	public static Connection getConnection() {
		System.out.println("Properties from file:" + p);
		try {
			// Class.forName("oracle.jdbc.driver.OracleDriver");
			Class.forName(p.getProperty("jdbc.driver"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try {
			System.out.println("Getting the connection from server");
			return DriverManager.getConnection(p.getProperty("jdbc.url"), p.getProperty("jdbc.username"),
					p.getProperty("jdbc.password"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	public static void closeConnection(Connection c) {
		try {
			if (c != null && !c.isClosed()) {
				System.out.println("Connection is closed");
				c.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void closePreparedStmt(PreparedStatement pstmt) {
		try {
			if (pstmt != null) {
				System.out.println("pstmt is closed");
				pstmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void closeResultSet(ResultSet rs) {
		try {
			if (rs != null) {
				System.out.println("rs is closed");
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
