package com.shipco.hackathon.PhoenixMonitor.server;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class ConnectionFactory {

	private static SqlSessionFactory sqlMapper;
	private static Reader reader; 
	static {
		try {  
			 
			reader =  Resources.getResourceAsReader("com/shipco/hackathon/PhoenixMonitor/configs/configuration.xml");
			sqlMapper = new SqlSessionFactoryBuilder().build(reader);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static SqlSessionFactory getSession() {
		return sqlMapper;
	}
}
