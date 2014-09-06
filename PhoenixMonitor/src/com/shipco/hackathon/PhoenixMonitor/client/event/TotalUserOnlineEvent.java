package com.shipco.hackathon.PhoenixMonitor.client.event;

import com.google.gwt.event.shared.GwtEvent;
import com.shipco.hackathon.PhoenixMonitor.shared.TimeBean;
import com.shipco.hackathon.PhoenixMonitor.shared.UserBean;

public class TotalUserOnlineEvent extends GwtEvent<TotalUserOnlineEventHandler> {

	public static Type<TotalUserOnlineEventHandler> TYPE = new Type<TotalUserOnlineEventHandler>();
	private TimeBean timeBean; 

	@Override
	public Type<TotalUserOnlineEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(TotalUserOnlineEventHandler handler) {

		handler.changeData(this);
	}

	public TimeBean getTimeBean() {
		return timeBean;
	}

	public void setTimeBean(TimeBean timeBean) {
		this.timeBean = timeBean;
	}

 

	

 
 

}
