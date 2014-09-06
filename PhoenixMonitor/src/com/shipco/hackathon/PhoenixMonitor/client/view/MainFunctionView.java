package com.shipco.hackathon.PhoenixMonitor.client.view;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel; 


public class MainFunctionView extends Composite   {

	private HorizontalPanel horizontalPanel = new HorizontalPanel();
	private VerticalPanel menuPanel = new VerticalPanel();
	private VerticalPanel detailPanel = new VerticalPanel();
	
	
	
	public MainFunctionView(){
		horizontalPanel.add(menuPanel);
		horizontalPanel.add(detailPanel);
		
		initWidget(horizontalPanel);

		
		
	}



	public HorizontalPanel getHorizontalPanel() {
		return horizontalPanel;
	}



	public VerticalPanel getMenuPanel() {
		return menuPanel;
	}



	public VerticalPanel getDetailPanel() {
		return detailPanel;
	}
	
	
	
 

}
