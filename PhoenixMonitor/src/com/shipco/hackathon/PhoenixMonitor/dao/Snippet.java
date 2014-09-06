package com.shipco.hackathon.PhoenixMonitor.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.shipco.hackathon.PhoenixMonitor.server.ConnectionFactory;
import com.shipco.hackathon.PhoenixMonitor.shared.TimeBean;

public class Snippet {
	public static void main(String[] args) {
		// sqlMapper = new SqlSessionFactoryBuilder().build(reader);

		Snippet  snippet  = new Snippet();
		snippet.load();
	}

	public void load() {

		System.out.println("Database query" );
		SqlSession session = null;
		try {
			session = ConnectionFactory.getSession().openSession();
			UserLoginDao userLoginDao = session.getMapper(UserLoginDao.class);
			List<TimeBean> timeBeans;

			timeBeans = userLoginDao.selectLastLogin();
			for(TimeBean timeBean: timeBeans){
				System.out.println(timeBean.getName() + " " + timeBean.getTime());
			}
            //Test add comment for git

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			session.close();
		}

	}

}
 