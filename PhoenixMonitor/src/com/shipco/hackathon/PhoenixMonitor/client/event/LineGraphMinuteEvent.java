package com.shipco.hackathon.PhoenixMonitor.client.event;

import java.util.ArrayList;
import java.util.HashMap;

import com.google.gwt.event.shared.GwtEvent;
import com.shipco.hackathon.PhoenixMonitor.client.model.EnumOptionLineGraph;
import com.shipco.hackathon.PhoenixMonitor.shared.LineGraphData;

public class LineGraphMinuteEvent extends GwtEvent<LineGraphMinuteEventHandler> {

	public static Type<LineGraphMinuteEventHandler> TYPE = new Type<LineGraphMinuteEventHandler>();
	private ArrayList<LineGraphData> lineGraphData = new  ArrayList<LineGraphData>();
	private HashMap<EnumOptionLineGraph, Object> options = new HashMap<EnumOptionLineGraph, Object>();
	@Override
	public Type<LineGraphMinuteEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(LineGraphMinuteEventHandler handler) {
		
		handler.setData(this);
	}

	public ArrayList<LineGraphData> getLineGraphData() {
		return lineGraphData;
	}

	public HashMap<EnumOptionLineGraph, Object> getOptions() {
		return options;
	}
 


 

}
