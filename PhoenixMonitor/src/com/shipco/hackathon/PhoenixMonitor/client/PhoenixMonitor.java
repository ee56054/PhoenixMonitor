package com.shipco.hackathon.PhoenixMonitor.client;

import java.util.ArrayList;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.RootPanel;
import com.shipco.hackathon.PhoenixMonitor.client.handler.TimerMonitor;
import com.shipco.hackathon.PhoenixMonitor.client.presenter.LineGraphDayPresenter;
import com.shipco.hackathon.PhoenixMonitor.client.presenter.LineGraphHourPresenter;
import com.shipco.hackathon.PhoenixMonitor.client.presenter.LineGraphMinutePresenter;
import com.shipco.hackathon.PhoenixMonitor.client.presenter.MonitorCompositePresenter;
import com.shipco.hackathon.PhoenixMonitor.client.presenter.SearchOperationPresenter;
import com.shipco.hackathon.PhoenixMonitor.client.presenter.SearchResultPresenter;
import com.shipco.hackathon.PhoenixMonitor.client.presenter.UserDetailPresenter;
import com.shipco.hackathon.PhoenixMonitor.client.view.LineGraphView;
import com.shipco.hackathon.PhoenixMonitor.client.view.MainFunctionView;
import com.shipco.hackathon.PhoenixMonitor.client.view.MainMonitorView;
import com.shipco.hackathon.PhoenixMonitor.client.view.MonitorCompositeView;
import com.shipco.hackathon.PhoenixMonitor.client.view.ResultView;
import com.shipco.hackathon.PhoenixMonitor.client.view.SearchOperationView;
import com.shipco.hackathon.PhoenixMonitor.client.view.Threme;
import com.shipco.hackathon.PhoenixMonitor.client.view.UserDetailView;
import com.shipco.hackathon.PhoenixMonitor.shared.LineGraphData;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class PhoenixMonitor implements EntryPoint {
 
	/**
	 * Create a remote service proxy to talk to the server-side Greeting
	 * service.
	 */
	private final UserLoginServiceAsync userLoginService = GWT.create(UserLoginService.class);
	private final MainMonitorView mainMonitorView = new MainMonitorView();
	private HandlerManager eventBus = new HandlerManager(null);
	private Threme theme = new Threme();

	/**
	 * This is the entry point method.
	 */
	@Override
	public void onModuleLoad() {

 		monitorView();

		// Timer refreshTimer = new Timer() {
		//
		// @Override
		// public void run() {
		//
		//
		//
		// try {
		// userLoginService
		// .getDayData(new AsyncCallback<List<TimeBean>>() {
		//
		// @Override
		// public void onSuccess(List<TimeBean> result) {
		// // for (TimeBean timeBean : result) {
		//
		// // System.out.println(timeBean.getInterval());
		// // }
		// setTopLeft(new ArrayList<LineGraphData>(
		// result));
		// setTopRight(new ArrayList<LineGraphData>(
		// result));
		// setBottomLeft(new ArrayList<LineGraphData>(
		// result));
		// setBottomRight(new ArrayList<LineGraphData>(
		// result));
		// }
		//
		// @Override
		// public void onFailure(Throwable caught) {
		//
		// }
		// });
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		//
		// mainMonitorView.getLeftVerticalPanel().clear();
		// mainMonitorView.getRightVerticalPanel().clear();
		//
		// RootPanel.get().add(mainMonitorView);
		//
		// }
		//
		// };
		//
		// refreshTimer.scheduleRepeating(5000);

		
		RootPanel.get().add(theme);
		
	}

	private void sesisonView() {

		MainFunctionView viewMain = new MainFunctionView();

		SearchOperationView operationView = new SearchOperationView();
		SearchOperationPresenter operationPresenter = new SearchOperationPresenter(eventBus, operationView);
		operationPresenter.go(viewMain.getDetailPanel());

		viewMain.getMenuPanel().add(operationView);

		ResultView resultView = new ResultView();
		SearchResultPresenter resultPresenter = new SearchResultPresenter(eventBus, resultView);
		resultPresenter.go(viewMain.getDetailPanel());

		viewMain.getMenuPanel().add(resultView);

		UserDetailView userDetailView = new UserDetailView();
		UserDetailPresenter detailPresenter = new UserDetailPresenter(eventBus, userDetailView);
		detailPresenter.go(viewMain.getDetailPanel());

		viewMain.getDetailPanel().add(userDetailView);

		RootPanel.get().clear();

		RootPanel.get().add(mainMonitorView);
	}

	private void monitorView() {


		theme.getMainFrame().add(mainMonitorView );
		setTopLeft(null);
		setTopRight(null);
		setBottomLeft(null);
		setBottomRight(null);

		Timer refreshTimer = new TimerMonitor(eventBus, userLoginService);
		refreshTimer.scheduleRepeating(5000);
	}

	
	
	
	private void setTopLeft(ArrayList<LineGraphData> datas) {
		MonitorCompositeView compositeView = new MonitorCompositeView();
		MonitorCompositePresenter compositePresenter = new MonitorCompositePresenter(compositeView, eventBus);
		compositePresenter.go(mainMonitorView.getLeftVerticalPanel());

	}

	private void setTopRight(ArrayList<LineGraphData> datas) {

		LineGraphView lineGraphView = new LineGraphView();
		LineGraphMinutePresenter lineGraphPresenter = new LineGraphMinutePresenter(eventBus, lineGraphView);
		lineGraphPresenter.go(mainMonitorView.getRightVerticalPanel());

	}

	private void setBottomLeft(ArrayList<LineGraphData> datas) {

		LineGraphView lineGraphView = new LineGraphView();
		LineGraphDayPresenter lineGraphPresenter = new LineGraphDayPresenter(eventBus, lineGraphView);
		lineGraphPresenter.go(mainMonitorView.getLeftVerticalPanel());

	}

	private void setBottomRight(ArrayList<LineGraphData> datas) {

		LineGraphView lineGraphView = new LineGraphView();
		LineGraphHourPresenter lineGraphPresenter = new LineGraphHourPresenter(eventBus, lineGraphView);
		lineGraphPresenter.go(mainMonitorView.getRightVerticalPanel());

	}


}
