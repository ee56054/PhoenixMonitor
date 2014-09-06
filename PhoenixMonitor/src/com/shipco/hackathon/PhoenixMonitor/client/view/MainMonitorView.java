package com.shipco.hackathon.PhoenixMonitor.client.view;

import com.github.gwtbootstrap.client.ui.Hero;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class MainMonitorView extends Composite   {

//	private HorizontalPanel horizontalPanel = new HorizontalPanel();
	private HorizontalPanel horizontalPanel = new HorizontalPanel();
	private VerticalPanel rightVerticalPanel = new VerticalPanel();
	private VerticalPanel leftVerticalPanel = new VerticalPanel(); 
	private Hero hero = new Hero();
	
	
	public MainMonitorView(){
		
		
		horizontalPanel.add(leftVerticalPanel);
		horizontalPanel.add(rightVerticalPanel);
		
		horizontalPanel.setStyleName("main_container");
		rightVerticalPanel.setStyleName("graph_container");
		leftVerticalPanel.setStyleName("graph_container");
		
		
		hero.add(horizontalPanel);
		hero.setHeight("80%");
		hero.setStyleName("hero");
		
		
		initWidget(hero);
 
		
	}



	public HorizontalPanel getHorizontalPanel() {
		return horizontalPanel;
	}



	public void setHorizontalPanel(HorizontalPanel horizontalPanel) {
		this.horizontalPanel = horizontalPanel;
	}



	public VerticalPanel getRightVerticalPanel() {
		return rightVerticalPanel;
	}



	public void setRightVerticalPanel(VerticalPanel rightVerticalPanel) {
		this.rightVerticalPanel = rightVerticalPanel;
	}



	public VerticalPanel getLeftVerticalPanel() {
		return leftVerticalPanel;
	}



	public void setLeftVerticalPanel(VerticalPanel leftVerticalPanel) {
		this.leftVerticalPanel = leftVerticalPanel;
	}

 


	 

}
