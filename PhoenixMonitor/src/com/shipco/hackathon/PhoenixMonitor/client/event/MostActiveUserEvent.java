package com.shipco.hackathon.PhoenixMonitor.client.event;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.event.shared.GwtEvent;
import com.shipco.hackathon.PhoenixMonitor.shared.MostActiveData;
import com.shipco.hackathon.PhoenixMonitor.shared.UserBean;

public class MostActiveUserEvent extends GwtEvent<MostActiveUserEventHandler> {

	public static Type<MostActiveUserEventHandler> TYPE = new Type<MostActiveUserEventHandler>();
	private UserBean userBean;
	private List<MostActiveData> mostActiveUserDatas = new ArrayList<MostActiveData>(); 

	@Override
	public Type<MostActiveUserEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(MostActiveUserEventHandler handler) {
		handler.changeData(this);
	}

	public UserBean getUserBeans() {
		return userBean;
	}

	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

	public List<MostActiveData> getMostActiveUserDatas() {
		return mostActiveUserDatas;
	}

 
 

}
