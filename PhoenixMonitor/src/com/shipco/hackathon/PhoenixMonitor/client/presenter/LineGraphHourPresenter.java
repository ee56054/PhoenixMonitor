package com.shipco.hackathon.PhoenixMonitor.client.presenter;

import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.HasWidgets;
import com.shipco.hackathon.PhoenixMonitor.client.event.LineGraphHourEvent;
import com.shipco.hackathon.PhoenixMonitor.client.event.LineGraphHourEventHandler;
import com.shipco.hackathon.PhoenixMonitor.client.view.LineGraphView;
import com.shipco.hackathon.PhoenixMonitor.client.view.LineGraphWidget;

public class LineGraphHourPresenter implements Presenter {

	private LineGraphView display; 

	// private final ContactsServiceAsync rpcService;
	private final HandlerManager eventBus;

	public LineGraphHourPresenter(HandlerManager eventBus, LineGraphView display) {
		super();
		this.display = display;
		this.eventBus = eventBus;

		bind();

	}

	private  void bind() {
	
		eventBus.addHandler(LineGraphHourEvent.TYPE, new LineGraphHourEventHandler() {

			@Override
			public void setData(LineGraphHourEvent event) { 
				display.clear(); 
				display.add(new LineGraphWidget(event.getOptions(), event.getLineGraphData()));

			}
		});

	}

	@Override
	public void go(HasWidgets container) {
		container.add(display);

	}

}
