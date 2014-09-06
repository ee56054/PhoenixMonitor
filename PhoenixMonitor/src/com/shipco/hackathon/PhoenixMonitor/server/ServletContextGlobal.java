package com.shipco.hackathon.PhoenixMonitor.server;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

/**
 * Application Lifecycle Listener implementation class ServletContextGlobal
 *
 */ 
public class ServletContextGlobal  {
	private static ServletContext servletContext;
 
	
	

	public static void setServletContext(ServletContext servletContext) {
		ServletContextGlobal.servletContext = servletContext;
	}




	public synchronized static ServletContext getServletContext() {
		return servletContext;
	}
    
    
    
	
}
