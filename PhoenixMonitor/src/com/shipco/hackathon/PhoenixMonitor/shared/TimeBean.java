package com.shipco.hackathon.PhoenixMonitor.shared;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class TimeBean implements LineGraphData, Serializable, MostActiveData {

	private int interval;
	private String count;
	private String userName;
	private Date loginTime;

	/**
	 * @return the interval
	 */
	public int getInterval() {
		return interval;
	}

	/**
	 * @param interval
	 *            the interval to set
	 */
	public void setInterval(int interval) {
		this.interval = interval;
	}

	/**
	 * @return the count
	 */
	public String getCount() {
		return count;
	}

	/**
	 * @param count
	 *            the count to set
	 */
	public void setCount(String count) {
		this.count = count;
	}

	@Override
	public int getValue() {
		return Integer.parseInt(count);
	}

	@Override
	public String getColumnName() {
		return Integer.toString(interval);
	}

	@Override
	public String getName() {
		return userName;
	}

	@Override
	public Date getTime() {
		return loginTime;
	}

}
