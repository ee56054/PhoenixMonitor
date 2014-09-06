package com.shipco.hackathon.PhoenixMonitor.client.model;

public enum EnumOptionLineGraph {
	ColumnName("Default"), 
	LineName("Default"), 
	Title("Company Performance"),
	Min(0),
	Max(100),
	Height(100),
	Width(100),
	
	;
	private Object defaultValue;

	private EnumOptionLineGraph(Object defaultValue) {
		this.defaultValue = defaultValue;
	}

	public Object getDefaultValue() {
		return defaultValue;
	}

	public void setDefaultValue(Object defaultValue) {
		this.defaultValue = defaultValue;
	}
	
}
