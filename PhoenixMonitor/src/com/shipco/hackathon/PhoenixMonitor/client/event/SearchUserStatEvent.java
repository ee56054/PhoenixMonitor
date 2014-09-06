package com.shipco.hackathon.PhoenixMonitor.client.event;

import java.util.List;

import com.google.gwt.event.shared.GwtEvent;
import com.shipco.hackathon.PhoenixMonitor.shared.UserBean;

public class SearchUserStatEvent extends GwtEvent<SearchUserStatEventHanlder> {

	private final List<UserBean> userBeans;
	public static Type<SearchUserStatEventHanlder> TYPE = new Type<SearchUserStatEventHanlder>();

	public SearchUserStatEvent(List<UserBean> userBeans) {
		this.userBeans = userBeans;
	}

	@Override
	public Type<SearchUserStatEventHanlder> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(SearchUserStatEventHanlder handler) {

		handler.onSearchUserStat(this);
	}

	/**
	 * @return the userBeans
	 */
	public List<UserBean> getUserBeans() {
		return userBeans;
	}

}
