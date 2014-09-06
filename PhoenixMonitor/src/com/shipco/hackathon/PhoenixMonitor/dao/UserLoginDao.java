package com.shipco.hackathon.PhoenixMonitor.dao;

import java.util.List;

import com.shipco.hackathon.PhoenixMonitor.shared.TimeBean;

public interface UserLoginDao {

	public List<TimeBean> selectMinuteData() throws Exception;

	public List<TimeBean> selectHourData() throws Exception;

	public List<TimeBean> selectDayData() throws Exception;
	
	public List<TimeBean> selectLastLogin() throws Exception;
	

	public TimeBean selectTotalOnline() throws Exception;
}