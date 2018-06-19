package com.conduent.servlet.login;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DisplayImageServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//Read the resource
		InputStream resourceAsStream = getServletContext().getResourceAsStream("images/suma.jpg");
		
		//set the image header
		resp.setContentType("image/jpeg");
		
		ServletOutputStream outputStream = resp.getOutputStream();
		// read inputstread and set to output stream
		int ch =0; ;  
	    while((ch=resourceAsStream.read())!=-1)  
	    {  
	    	outputStream.write(ch);  
	    }  
	    
	    outputStream.flush();
	    
	    outputStream.close();
	    resourceAsStream.close();
	}
}	
