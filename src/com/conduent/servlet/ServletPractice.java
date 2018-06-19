package com.conduent.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ServletPractice implements Servlet {
	int count;
	String connection;
	ServletConfig config;

	public ServletPractice(int i) {
		System.out.println("Constructor" + i);
	}

	public ServletPractice() {
		System.out.println("Constructor");
	}

	@Override
	public void destroy() {
		System.out.println("destroy");
		this.connection = null; // closing connection
		System.out.println("Connection closed ");
		// any activity before destry
		// close the connection.
	}

	@Override
	public ServletConfig getServletConfig() {
		System.out.println("servlet config");

		return this.config;
	}

	@Override
	public String getServletInfo() {
		System.out.println("servlet info");
		return this.config.getServletName();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init method" + config);
		this.config = config;
		this.connection = "I got the connection";
		// any activity which has to do only do here
		// getting connection.

	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("service");
		PrintWriter writer = res.getWriter();
		writer.println("<h1>welcome to servlet practice</h1>");
		// writer.println("<h4> " + new Date() + " Done with servlet introduction</h4>"
		// + count++);
		// writer.println("Name " + getServletInfo());
		// writer.println("Database username: " +
		// getServletConfig().getInitParameter("username"));
		// writer.println("class name: "+ getServletConfig().getClass() + "<br>");
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "test", "test");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from servlettable");
			writer.println("<table border='1'><tr><th>Name</th><th>Id</th></tr>");
			while (rs.next()) {
				String name = rs.getString("name");
				int id = rs.getInt("id");
				writer.println("<tr><td>"+ name + "</td><td>"+ id + "</td></tr>");
			}
			writer.print("</table>");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
