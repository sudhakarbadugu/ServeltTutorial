package com.conduent.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class WelcomeServlet extends GenericServlet {
	Connection con;
	public WelcomeServlet() {
	}

	@Override
	public void init() throws ServletException {
		System.out.println("custom init");
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			 con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "test", "test");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public void destroy() {
		super.destroy();
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("connection closed");
	}
	
	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		writer.println("<h1> Welcome to Generic Servlet</h1>" + getServletConfig());
		writer.println("username: "+ getInitParameter("username"));
		writer.println("name: "+ getServletName());
		writer.println("class name: "+ getClass());
		try {
			Statement stmt = con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from servlettable");
			writer.println("name   id");
			while(rs.next()) {
				String name=rs.getString("name");
				int id=rs.getInt("id");
				writer.println(name+" "+id);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
