package com.shipco.hackathon.PhoenixMonitor.client.view;

import com.github.gwtbootstrap.client.ui.Hero;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class Threme extends Composite {

	private static ThremeUiBinder uiBinder = GWT.create(ThremeUiBinder.class);
 
	interface ThremeUiBinder extends UiBinder<Widget, Threme> {
	}
	
	@UiField
	Hero mainFrame;

	public Threme() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	public Hero getMainFrame() {
		return mainFrame;
	}
	
	
	

}
