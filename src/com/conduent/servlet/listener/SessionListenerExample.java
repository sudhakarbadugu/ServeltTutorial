package com.conduent.servlet.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListenerExample implements HttpSessionListener {
	static int count = 0;
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("Session created." );
		count++;
		System.out.println("Session count: "+ count);
	}
	
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("Session destroyed");
		count--;
		System.out.println("Session count: "+ count);
	}
}
