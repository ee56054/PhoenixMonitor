package com.shipco.hackathon.PhoenixMonitor.client.view;

import java.util.ArrayList;
import java.util.HashMap;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.visualization.client.AbstractDataTable.ColumnType;
import com.google.gwt.visualization.client.DataTable;
import com.google.gwt.visualization.client.LegendPosition;
import com.google.gwt.visualization.client.visualizations.corechart.AxisOptions;
import com.google.gwt.visualization.client.visualizations.corechart.LineChart;
import com.google.gwt.visualization.client.visualizations.corechart.Options;
import com.shipco.hackathon.PhoenixMonitor.client.handler.OnMouseOutDemo;
import com.shipco.hackathon.PhoenixMonitor.client.handler.OnMouseOverDemo;
import com.shipco.hackathon.PhoenixMonitor.client.handler.ReadyDemo;
import com.shipco.hackathon.PhoenixMonitor.client.handler.SelectionDemo;
import com.shipco.hackathon.PhoenixMonitor.client.model.EnumOptionLineGraph;
import com.shipco.hackathon.PhoenixMonitor.shared.LineGraphData;

public class LineGraphWidget extends Composite {

	private Options options = Options.create();
	private AxisOptions vAxisOptions = AxisOptions.create();
	private DataTable dataTable = DataTable.create();
	private LineChart lineChart;
	private HashMap<EnumOptionLineGraph, Object> enumOptionLine;

	public LineGraphWidget(HashMap<EnumOptionLineGraph, Object> enumOptionLine, ArrayList<LineGraphData> datas) {
		this.enumOptionLine = enumOptionLine;

		String columnName = (String) getValue(EnumOptionLineGraph.ColumnName);
		String lineName = (String) getValue(EnumOptionLineGraph.LineName);
		dataTable.addColumn(ColumnType.STRING, columnName);
		dataTable.addColumn(ColumnType.NUMBER, lineName);
		dataTable.addRows(datas.size() + 1);

		setData(datas);

		setWidget();

		initWidget(lineChart);

	}

	private void setWidget() {
		int height = (Integer) getValue(EnumOptionLineGraph.Height);
		int width = (Integer) getValue(EnumOptionLineGraph.Width);
		int minValue = (Integer) getValue(EnumOptionLineGraph.Min);
		int maxValue = (Integer) getValue(EnumOptionLineGraph.Max);
		String title = (String) getValue(EnumOptionLineGraph.Title);

		options.setFontName("Alegreya Sans SC");
		options.setFontSize(16);
		options.setLineWidth(1);
		options.setColors("#c0392b");
		options.setGridlineColor("#ecf0f1");
		options.setBackgroundColor("white");
		options.setAxisTitlesPosition("out");
		options.setLegend(LegendPosition.RIGHT);

		options.setHeight(height);
		options.setTitle(title);
		options.setWidth(width);
		options.setInterpolateNulls(true);
		vAxisOptions.setMinValue(minValue);
		vAxisOptions.setMaxValue(maxValue);
		options.setVAxisOptions(vAxisOptions);

		lineChart = new LineChart(dataTable, options);

		Label status = new Label();
		Label onMouseOverAndOutStatus = new Label();
		lineChart.addSelectHandler(new SelectionDemo(lineChart, status));
		lineChart.addReadyHandler(new ReadyDemo(status));
		lineChart.addOnMouseOverHandler(new OnMouseOverDemo(onMouseOverAndOutStatus));
		lineChart.addOnMouseOutHandler(new OnMouseOutDemo(onMouseOverAndOutStatus));
	}

	private void setData(ArrayList<LineGraphData> datas) {

		int i = 0;

		for (LineGraphData data : datas) {
			i++;
			dataTable.setValue(i, 0, data.getColumnName());
			dataTable.setValue(i, 1, data.getValue());

		}

	}

	private Object getValue(EnumOptionLineGraph enumOptionLineGraph) {
		Object object = enumOptionLine.containsKey(enumOptionLineGraph) ? enumOptionLine.get(enumOptionLineGraph) : enumOptionLineGraph.getDefaultValue();
		return object;
	}

}
