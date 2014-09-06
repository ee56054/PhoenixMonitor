package com.shipco.hackathon.PhoenixMonitor.client.event;

import com.google.gwt.event.shared.GwtEvent;
import com.shipco.hackathon.PhoenixMonitor.shared.UserBean;

public class ShowUserDetailEvent extends GwtEvent<ShowUserDetailEventHandler> {

	public static Type<ShowUserDetailEventHandler> TYPE = new Type<ShowUserDetailEventHandler>();
	private UserBean userBean;

	@Override
	public Type<ShowUserDetailEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(ShowUserDetailEventHandler handler) {

		handler.onSearchUserStat(this);
	}

	public UserBean getUserBeans() {
		return userBean;
	}

	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

}
