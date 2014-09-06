package com.shipco.hackathon.PhoenixMonitor.server;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.shipco.hackathon.PhoenixMonitor.client.UserLoginService;
import com.shipco.hackathon.PhoenixMonitor.dao.UserLoginDao;
import com.shipco.hackathon.PhoenixMonitor.shared.TimeBean;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class UserLoginServiceImpl extends RemoteServiceServlet implements UserLoginService {
	  
	private TimerTask timerTask;
	private Timer timer = new Timer();

	@Override
	public List<TimeBean> getMinuteData() throws Exception {

		@SuppressWarnings("unchecked")
		List<TimeBean> timeBeans = (List<TimeBean>) getData(EnumApplicationParameter.MinuteData);
		if (timeBeans == null) {
			timeBeans = new ArrayList<TimeBean>();
		}

		return timeBeans;

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TimeBean> getHourData() throws Exception {
		List<TimeBean> timeBeans = (List<TimeBean>) getData(EnumApplicationParameter.HourData);
		if (timeBeans == null) {
			timeBeans = new ArrayList<>();
		}
		return timeBeans;

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TimeBean> getDayData() throws Exception {
		trigger();
		UserSessionTimeTrigger.increaseCountRequest();
		List<TimeBean> timeBeans = (List<TimeBean>) getData(EnumApplicationParameter.DayData);
		if (timeBeans == null) {
			timeBeans = new ArrayList<>();
		}
		return timeBeans;

	}

	@Override
	public List<TimeBean> getLastUserLogin() throws Exception {
		List<TimeBean> timeBeans = (List<TimeBean>) getData(EnumApplicationParameter.LastLogin);
		if (timeBeans == null) {
			timeBeans = new ArrayList<>();
		}
		return timeBeans;
	}
	

	@Override
	public TimeBean selectTotalOnline() throws Exception {
		 TimeBean timeBean = (TimeBean) getData(EnumApplicationParameter.TotalUserOnline);
		if (timeBean == null) {
			timeBean = new TimeBean();
		}
		return timeBean;
	}

	private  void trigger() {

		if (timerTask == null) {

			timerTask = new UserSessionTimeTrigger();
			timer.schedule(timerTask, 1000, 5000);

		}

		System.out.println("timerTask :" + timerTask);
	}

	private Object getData(EnumApplicationParameter applicationParameter) {
		if(ServletContextGlobal.getServletContext() == null){
			ServletContextGlobal.setServletContext(perThreadRequest.get().getSession().getServletContext());
		}
		
		return ServletContextGlobal.getServletContext().getAttribute(applicationParameter.name());
	}



 


}
