package com.shipco.hackathon.PhoenixMonitor.client.event;

import java.util.ArrayList;
import java.util.HashMap;

import com.google.gwt.event.shared.GwtEvent;
import com.shipco.hackathon.PhoenixMonitor.client.model.EnumOptionLineGraph;
import com.shipco.hackathon.PhoenixMonitor.shared.LineGraphData;

public class LineGraphDayEvent extends GwtEvent<LineGraphDayEventHandler> {

	public static Type<LineGraphDayEventHandler> TYPE = new Type<LineGraphDayEventHandler>();
	private ArrayList<LineGraphData> lineGraphData = new  ArrayList<LineGraphData>();
	private HashMap<EnumOptionLineGraph, Object> options = new HashMap<EnumOptionLineGraph, Object>();
	@Override
	public Type<LineGraphDayEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(LineGraphDayEventHandler handler) {
		
		handler.setData(this);
	}

	public ArrayList<LineGraphData> getLineGraphData() {
		return lineGraphData;
	}

	public HashMap<EnumOptionLineGraph, Object> getOptions() {
		return options;
	}
 


 

}
