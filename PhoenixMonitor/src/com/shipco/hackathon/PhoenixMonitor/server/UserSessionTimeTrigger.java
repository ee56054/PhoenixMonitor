package com.shipco.hackathon.PhoenixMonitor.server;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

import org.apache.ibatis.session.SqlSession;

import com.shipco.hackathon.PhoenixMonitor.dao.UserLoginDao;
import com.shipco.hackathon.PhoenixMonitor.shared.TimeBean;

public class UserSessionTimeTrigger extends TimerTask {
	private static int countRequest = 0;

	@Override
	public void run() {
		System.out.println("Database query" + this);
		SqlSession session = null;
		try {
			session = ConnectionFactory.getSession().openSession();
			UserLoginDao userLoginDao = session.getMapper(UserLoginDao.class);
			List<TimeBean> timeBeans;

			timeBeans = userLoginDao.selectDayData();

			List<TimeBean> finalTimeBeans = new ArrayList<TimeBean>();

			int interval = 1;
			for (TimeBean timeBean : timeBeans) {

				if (timeBean.getInterval() != interval) {
					for (int i = interval; i <= timeBean.getInterval(); i++) {
						if (i == timeBean.getInterval()) {

							finalTimeBeans.add(timeBean);
						} else {

							TimeBean emptyTimeBean = new TimeBean();
							emptyTimeBean.setInterval(i);
							emptyTimeBean.setCount("0");
							finalTimeBeans.add(emptyTimeBean);
						}
					}
				} else {
					finalTimeBeans.add(timeBean);
				}
				interval++;
			}

			putData(EnumApplicationParameter.DayData, finalTimeBeans);

			timeBeans = userLoginDao.selectHourData();

			finalTimeBeans = new ArrayList<>();

			interval = 1;
			for (TimeBean timeBean : timeBeans) {

				if (timeBean.getInterval() != interval) {
					for (int i = interval; i <= timeBean.getInterval(); i++) {
						if (i == timeBean.getInterval()) {

							finalTimeBeans.add(timeBean);
						} else {

							TimeBean emptyTimeBean = new TimeBean();
							emptyTimeBean.setInterval(i);
							emptyTimeBean.setCount("0");
							finalTimeBeans.add(emptyTimeBean);
						}
					}
				} else {
					finalTimeBeans.add(timeBean);
				}
				interval++;
			}

			putData(EnumApplicationParameter.HourData, finalTimeBeans);

			timeBeans = userLoginDao.selectMinuteData();

			finalTimeBeans = new ArrayList<>();

			interval = 1;
			for (TimeBean timeBean : timeBeans) {

				if (timeBean.getInterval() != interval) {
					for (int i = interval; i <= timeBean.getInterval(); i++) {
						if (i == timeBean.getInterval()) {

							finalTimeBeans.add(timeBean);
						} else {

							TimeBean emptyTimeBean = new TimeBean();
							emptyTimeBean.setInterval(i);
							emptyTimeBean.setCount("0");
							finalTimeBeans.add(emptyTimeBean);
						}
					}
				} else {
					finalTimeBeans.add(timeBean);
				}
				interval++;
			}

			putData(EnumApplicationParameter.MinuteData, finalTimeBeans);

			timeBeans = userLoginDao.selectLastLogin();
			finalTimeBeans = new ArrayList<>();
			interval = 1;
			for (TimeBean timeBean : timeBeans) {
				timeBean.setInterval(interval);
				interval++;
			}

			System.out.println("LastLogin:" + finalTimeBeans.size());
			putData(EnumApplicationParameter.LastLogin, timeBeans);

			TimeBean timeBean = userLoginDao.selectTotalOnline();
			putData(EnumApplicationParameter.TotalUserOnline, timeBean);

			// session =
			// ConnectionFactory.getSession().openSession();
			// UserLoginDao userLoginDao =
			// session.getMapper(UserLoginDao.class);
			// List<TimeBean> timeBeans =
			// userLoginDao.selectHourData();
			//
			//
			// session =
			// ConnectionFactory.getSession().openSession();
			// UserLoginDao userLoginDao =
			// session.getMapper(UserLoginDao.class);
			// List<TimeBean> timeBeans =
			// userLoginDao.selectMinuteData();
			// timeBeans.add(new TimeBean());
			// return timeBeans;

			// check user have request
			if (countRequest == 0) {
				this.cancel();
				return;
			}

			countRequest = 0;

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			session.close();
		}
		System.out.println("finish");

	}
	
	
	 

	private void putData(EnumApplicationParameter applicationParameter, Object obj) {
		ServletContextGlobal.getServletContext().setAttribute(applicationParameter.name(), obj);
	}

	 




	public static void increaseCountRequest() { 
		countRequest++;
		
		
	}

}
