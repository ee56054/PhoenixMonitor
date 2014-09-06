package com.shipco.hackathon.PhoenixMonitor.client.presenter;

import java.util.List;

import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Label;
import com.shipco.hackathon.PhoenixMonitor.client.event.MostActiveOfficeEvent;
import com.shipco.hackathon.PhoenixMonitor.client.event.MostActiveOfficeEventHandler;
import com.shipco.hackathon.PhoenixMonitor.client.event.MostActiveUserEvent;
import com.shipco.hackathon.PhoenixMonitor.client.event.MostActiveUserEventHandler;
import com.shipco.hackathon.PhoenixMonitor.client.event.TotalUserOnlineEvent;
import com.shipco.hackathon.PhoenixMonitor.client.event.TotalUserOnlineEventHandler;
import com.shipco.hackathon.PhoenixMonitor.client.view.MonitorCompositeView;
import com.shipco.hackathon.PhoenixMonitor.shared.MostActiveData;

public class MonitorCompositePresenter implements Presenter {

	private MonitorCompositeView display;
	private HandlerManager eventBus;

	public MonitorCompositePresenter(MonitorCompositeView display, HandlerManager eventBus) {
		this.display = display;
		this.eventBus = eventBus;
		bind();
	}

	private void bind() {

		eventBus.addHandler(MostActiveUserEvent.TYPE, new MostActiveUserEventHandler() {

			@Override
			public void changeData(MostActiveUserEvent event) {

				changeDataMostActive(event.getMostActiveUserDatas());

			}

		});

		eventBus.addHandler(MostActiveOfficeEvent.TYPE, new MostActiveOfficeEventHandler() {

			@Override
			public void changeData(MostActiveOfficeEvent event) {

				changeDataMostOffice(event.getMostActiveOfficeDatas());
			}
		});

		eventBus.addHandler(TotalUserOnlineEvent.TYPE, new TotalUserOnlineEventHandler() {

			@Override
			public void changeData(TotalUserOnlineEvent event) {
				NumberFormat fmt = NumberFormat.getDecimalFormat();
				display.getLabelTotal().setText(fmt.format(event.getTimeBean().getInterval()));

			}
		});

	}

	private void changeDataMostOffice(List<MostActiveData> mostOfficeUserDatas) {
		FlexTable flexTable = display.getFlexTableMostOffice();

		int line = 1;
		for (MostActiveData activeUserData : mostOfficeUserDatas) {
			flexTable.setWidget(line, 0, new Label(line + ""));
			flexTable.setWidget(line, 1, new Label(activeUserData.getName()));
			flexTable.setWidget(line, 2, new Label(DateTimeFormat.getShortDateTimeFormat().format(activeUserData.getTime())));
			line++;

		}
	}

	private void changeDataMostActive(List<MostActiveData> mostActiveDataes) {
		FlexTable flexTable = display.getFlexTableMostActive();

		int line = 1;
		for (MostActiveData activeUserData : mostActiveDataes) {
			flexTable.setWidget(line, 0, new Label(line + ""));
			flexTable.setWidget(line, 1, new Label(activeUserData.getName()));

			flexTable.setWidget(line, 2, new Label(DateTimeFormat.getShortDateTimeFormat().format(activeUserData.getTime())));
			line++;

		}

	}

	@Override
	public void go(HasWidgets container) {
		container.add(display);
	}

}
