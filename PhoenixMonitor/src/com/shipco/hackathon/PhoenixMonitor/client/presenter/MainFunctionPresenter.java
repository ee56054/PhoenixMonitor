package com.shipco.hackathon.PhoenixMonitor.client.presenter;

import com.google.gwt.user.client.ui.HasAlignment;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;
import com.shipco.hackathon.PhoenixMonitor.client.view.MainFunctionView;

public class MainFunctionPresenter implements Presenter {

	public interface Display { 
		HasAlignment getMenuPanel();
		HasAlignment getDetailPanel();
		Widget asWidget();
	}

	private Display displayMain;  
	
	public MainFunctionPresenter(){ 
		
		
	}
	
	
	@Override
	public void go(HasWidgets container) { 

	}

}
