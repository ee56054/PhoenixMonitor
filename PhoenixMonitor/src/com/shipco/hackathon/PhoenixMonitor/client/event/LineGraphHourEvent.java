package com.shipco.hackathon.PhoenixMonitor.client.event;

import java.util.ArrayList;
import java.util.HashMap;

import com.google.gwt.event.shared.GwtEvent;
import com.shipco.hackathon.PhoenixMonitor.client.model.EnumOptionLineGraph;
import com.shipco.hackathon.PhoenixMonitor.shared.LineGraphData;

public class LineGraphHourEvent extends GwtEvent<LineGraphHourEventHandler> {

	public static Type<LineGraphHourEventHandler> TYPE = new Type<LineGraphHourEventHandler>();
	private ArrayList<LineGraphData> lineGraphData = new  ArrayList<LineGraphData>();
	private HashMap<EnumOptionLineGraph, Object> options = new HashMap<EnumOptionLineGraph, Object>();
	@Override
	public Type<LineGraphHourEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(LineGraphHourEventHandler handler) {
		handler.setData(this);
	}

	public ArrayList<LineGraphData> getLineGraphData() {
		return lineGraphData;
	}

	public HashMap<EnumOptionLineGraph, Object> getOptions() {
		return options;
	}
 


 

}
