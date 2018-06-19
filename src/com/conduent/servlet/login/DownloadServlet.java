package com.conduent.servlet.login;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownloadServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Enumeration<String> parameterNames = req.getParameterNames();
		while(parameterNames.hasMoreElements()) {
			String nextElement = parameterNames.nextElement();
			System.out.println("Download Servlet: "+ nextElement);
		}

		//set content type
		resp.setContentType("APPLICATION/OCTET-STREAM");   
		
		String fileName = null;
		Enumeration<String> fileNames = req.getParameterNames();
		while(fileNames.hasMoreElements()) {
			String paramName = fileNames.nextElement();
			fileName = req.getParameter(paramName);
			
		}
		resp.setHeader("Content-Disposition","attachment; filename="+fileName);   
		String fullFilePath = "reports/"+ fileName;
		System.out.println("Downloading the file: "+ fullFilePath);
		//Read the resource
//		InputStream resourceAsStream = getServletContext().getResourceAsStream("images/suma.jpg");
		InputStream resourceAsStream = getServletContext().getResourceAsStream(fullFilePath);
		
		ServletOutputStream outputStream = resp.getOutputStream();
		// read inputstread and set to output stream
		try {
			int ch =0; ;  
			while((ch=resourceAsStream.read())!=-1)  
			{  
				outputStream.write(ch);  
			}  
		}catch(Exception e) {
			
		}
	    
	    outputStream.flush();
	    outputStream.close();
	    resourceAsStream.close();

				
		
		req.setAttribute("downloaded", true);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/stagingServlet");
		requestDispatcher.forward(req, resp);
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
