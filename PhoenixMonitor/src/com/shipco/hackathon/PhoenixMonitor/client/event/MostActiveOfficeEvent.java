package com.shipco.hackathon.PhoenixMonitor.client.event;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.event.shared.GwtEvent;
import com.shipco.hackathon.PhoenixMonitor.shared.MostActiveData;
import com.shipco.hackathon.PhoenixMonitor.shared.UserBean;

public class MostActiveOfficeEvent extends GwtEvent<MostActiveOfficeEventHandler> {

	public static Type<MostActiveOfficeEventHandler> TYPE = new Type<MostActiveOfficeEventHandler>();
	private UserBean userBean;
	private List<MostActiveData> mostActiveUserDatas = new ArrayList<MostActiveData>();
	private List<MostActiveData> mostActiveOfficeDatas = new ArrayList<MostActiveData>();

	@Override
	public Type<MostActiveOfficeEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(MostActiveOfficeEventHandler handler) {
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

	public List<MostActiveData> getMostActiveOfficeDatas() {
		return mostActiveOfficeDatas;
	}
 

}
