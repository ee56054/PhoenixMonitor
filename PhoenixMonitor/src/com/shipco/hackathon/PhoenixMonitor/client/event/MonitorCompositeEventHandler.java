package com.shipco.hackathon.PhoenixMonitor.client.event;

import com.google.gwt.event.shared.EventHandler;

public interface MonitorCompositeEventHandler extends EventHandler {

	void changeData(MonitorCompositeEvent event);
}
