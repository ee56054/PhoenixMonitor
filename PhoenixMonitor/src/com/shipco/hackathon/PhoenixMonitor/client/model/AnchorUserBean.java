package com.shipco.hackathon.PhoenixMonitor.client.model;

import com.google.gwt.user.client.ui.Anchor;
import com.shipco.hackathon.PhoenixMonitor.shared.UserBean;

public class AnchorUserBean extends Anchor {

	private UserBean userbean;

	
	public AnchorUserBean(String anchor){
		super(anchor);
	}

	public UserBean getUserbean() {
		return userbean;
	}

	public void setUserbean(UserBean userbean) {
		this.userbean = userbean;
	}
}
