package com.shipco.hackathon.PhoenixMonitor.client.event;

import com.google.gwt.event.shared.EventHandler;

public interface MostActiveUserEventHandler extends EventHandler {

	void changeData(MostActiveUserEvent event);
}
