package com.shipco.hackathon.PhoenixMonitor.client.handler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.shipco.hackathon.PhoenixMonitor.client.UserLoginServiceAsync;
import com.shipco.hackathon.PhoenixMonitor.client.event.LineGraphDayEvent;
import com.shipco.hackathon.PhoenixMonitor.client.event.LineGraphHourEvent;
import com.shipco.hackathon.PhoenixMonitor.client.event.LineGraphMinuteEvent;
import com.shipco.hackathon.PhoenixMonitor.client.event.MonitorCompositeEvent;
import com.shipco.hackathon.PhoenixMonitor.client.event.MostActiveUserEvent;
import com.shipco.hackathon.PhoenixMonitor.client.event.TotalUserOnlineEvent;
import com.shipco.hackathon.PhoenixMonitor.client.model.EnumOptionLineGraph;
import com.shipco.hackathon.PhoenixMonitor.shared.LineGraphData;
import com.shipco.hackathon.PhoenixMonitor.shared.MostActiveData;
import com.shipco.hackathon.PhoenixMonitor.shared.TimeBean;

public class TimerMonitor extends Timer {

	private HandlerManager eventBus;
	private UserLoginServiceAsync userLoginService;

	public TimerMonitor(HandlerManager eventBus2, UserLoginServiceAsync userLoginService) {
		super();
		this.eventBus = eventBus2;
		this.userLoginService = userLoginService;
	}

	@Override
	public void run() {

		try {

			userLoginService.selectTotalOnline(new AsyncCallback<TimeBean>() {

				@Override
				public void onSuccess(TimeBean result) {
					TotalUserOnlineEvent totalUserOnlineEvent = new TotalUserOnlineEvent();
					totalUserOnlineEvent.setTimeBean(result);
					eventBus.fireEvent(totalUserOnlineEvent);
				}

				@Override
				public void onFailure(Throwable caught) {

				}
			});

			userLoginService.getLastUserLogin(new AsyncCallback<List<TimeBean>>() {

				@Override
				public void onFailure(Throwable caught) {

				}

				@Override
				public void onSuccess(List<TimeBean> result) {  
					MostActiveUserEvent mostActiveUserEvent = new  MostActiveUserEvent();
					mostActiveUserEvent.getMostActiveUserDatas().addAll(result);
					eventBus.fireEvent(mostActiveUserEvent);
					
				}
			});

			userLoginService.getMinuteData(new AsyncCallback<List<TimeBean>>() {

				@Override
				public void onFailure(Throwable caught) {

				}

				@Override
				public void onSuccess(List<TimeBean> result) {
					LineGraphMinuteEvent lineGraphMinuteEvent = new LineGraphMinuteEvent();
					ArrayList<LineGraphData> datas = new ArrayList<LineGraphData>(result);// generateDataGraph();
					lineGraphMinuteEvent.getLineGraphData().addAll(datas);
					LineGraphDayEvent lineGraphDayEvent = new LineGraphDayEvent();
					HashMap<EnumOptionLineGraph, Object> options = lineGraphDayEvent.getOptions();
					options = lineGraphMinuteEvent.getOptions();
					options.put(EnumOptionLineGraph.Width, 600);
					options.put(EnumOptionLineGraph.Height, 300);
					options.put(EnumOptionLineGraph.Title, "Users Online / Minute");
					options.put(EnumOptionLineGraph.LineName, "Users");
					eventBus.fireEvent(lineGraphMinuteEvent);
				}
			});

			userLoginService.getHourData(new AsyncCallback<List<TimeBean>>() {

				@Override
				public void onFailure(Throwable caught) {

				}

				@Override
				public void onSuccess(List<TimeBean> result) {
					LineGraphHourEvent lineGraphHourEvent = new LineGraphHourEvent();
					ArrayList<LineGraphData> datas = new ArrayList<LineGraphData>(result);// generateDataGraph();
					lineGraphHourEvent.getLineGraphData().addAll(datas);
					LineGraphDayEvent lineGraphDayEvent = new LineGraphDayEvent();
					HashMap<EnumOptionLineGraph, Object> options = lineGraphDayEvent.getOptions();
					options = lineGraphHourEvent.getOptions();
					options.put(EnumOptionLineGraph.Width, 600);
					options.put(EnumOptionLineGraph.Height, 300);
					options.put(EnumOptionLineGraph.Title, "Users Online / Hour");
					options.put(EnumOptionLineGraph.LineName, "Users");
					eventBus.fireEvent(lineGraphHourEvent);
				}
			});

			userLoginService.getDayData(new AsyncCallback<List<TimeBean>>() {

				@Override
				public void onSuccess(List<TimeBean> result) {

					ArrayList<LineGraphData> datas = new ArrayList<LineGraphData>(result);// generateDataGraph();

					LineGraphDayEvent lineGraphDayEvent = new LineGraphDayEvent();
					lineGraphDayEvent.getLineGraphData().addAll(datas);
					HashMap<EnumOptionLineGraph, Object> options = lineGraphDayEvent.getOptions();
					options.put(EnumOptionLineGraph.Width, 600);
					options.put(EnumOptionLineGraph.Height, 300);
					options.put(EnumOptionLineGraph.Title, "Users Online / Day");
					options.put(EnumOptionLineGraph.LineName, "Users");
					eventBus.fireEvent(lineGraphDayEvent);

				}

				@Override
				public void onFailure(Throwable caught) {

				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private Collection<? extends MostActiveData> generateData() {

		ArrayList<MostActiveData> datas = new ArrayList<MostActiveData>();
		for (int i = 1; i <= 5; i++) {
			final int x = i;
			datas.add(new MostActiveData() {

				@Override
				public String getName() {
					return "" + x;
				}

				@Override
				public Date getTime() {
					return new Date();
				}

			});

		}
		return datas;

	}

	private ArrayList<LineGraphData> generateDataGraph() {

		ArrayList<LineGraphData> datas = new ArrayList<LineGraphData>();
		for (int i = 1; i < 10; i++) {
			final int x = i;
			datas.add(new LineGraphData() {

				@Override
				public int getValue() {
					return (int) (x * x * Math.random());
				}

				@Override
				public String getColumnName() {
					return "" + x;
				}
			});

		}
		return datas;

	}

}
