package com.shipco.hackathon.PhoenixMonitor.client.view;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.FlexTable.FlexCellFormatter;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

public class MonitorCompositeView extends Composite {

	private VerticalPanel verticalPanel = new VerticalPanel();
	private HorizontalPanel horizontalPanelTop = new HorizontalPanel();
	private HorizontalPanel horizontalPanelBottom = new HorizontalPanel();
	private FlexTable flexTableMostActive = new FlexTable();
	private FlexTable flexTableMostOffice = new FlexTable();
	private Label labelUserOnline = new Label("User Online:");
	private Label labelTotal = new Label("  ");
	private Label today = new Label(" Today");

	public MonitorCompositeView() {

		setWidget();
		setStyle();
		initWidget(verticalPanel);

	}

	private void setWidget() {
		horizontalPanelTop.add(labelUserOnline);
		horizontalPanelTop.add(labelTotal);
		horizontalPanelTop.add(today);

		flexTableMostActive.setWidget(0, 0, new Label("Last Active User"));
//		flexTableMostActive.setWidget(1, 0, new Label("Order"));
//		flexTableMostActive.setWidget(1, 1, new Label("User Name"));
//		flexTableMostActive.setWidget(1, 2, new Label("Time"));

		flexTableMostOffice.setWidget(0, 0, new Label("Most Active Office"));
//		flexTableMostOffice.setWidget(1, 0, new Label("Order"));
//		flexTableMostOffice.setWidget(1, 1, new Label("Office Name"));
//		flexTableMostOffice.setWidget(1, 2, new Label("Time"));

		horizontalPanelBottom.add(flexTableMostActive);
		horizontalPanelBottom.add(flexTableMostOffice);

		verticalPanel.add(horizontalPanelTop);
//		verticalPanel.add(horizontalPanelBottom);
		verticalPanel.add(flexTableMostActive);
		
	}
 
	
	
	private void setStyle() {

		
		verticalPanel.setStyleName("lineGraphView");
		
		labelUserOnline.setStyleName("composite_monitor_big_label");
		labelTotal.setStyleName("composite_monitor_big_label");
		today.setStyleName("composite_monitor_big_label");

		horizontalPanelTop.setWidth("100%"); 
		horizontalPanelTop.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE );
		
		
		verticalPanel.setHeight("300px");
		verticalPanel.setWidth("100%");
		horizontalPanelBottom.setWidth("100%");


	

		flexTableMostActive.setStyleName("composite_monitor_flextable"); 
		FlexCellFormatter cellFormatterMostActive =  flexTableMostActive.getFlexCellFormatter();
		cellFormatterMostActive.setColSpan(0, 0, 3);
		cellFormatterMostActive.setAlignment(0, 0, HasHorizontalAlignment.ALIGN_CENTER, HasVerticalAlignment.ALIGN_MIDDLE);
		
		

		
		FlexCellFormatter cellFormatterMostOffice =  flexTableMostOffice.getFlexCellFormatter();
		cellFormatterMostOffice.setColSpan(0, 0, 3);
		cellFormatterMostOffice.setAlignment(0, 0, HasHorizontalAlignment.ALIGN_CENTER, HasVerticalAlignment.ALIGN_MIDDLE);
		
		
		flexTableMostOffice.setStyleName("composite_monitor_flextable");

	}

	public VerticalPanel getVerticalPanel() {
		return verticalPanel;
	}

	public void setVerticalPanel(VerticalPanel verticalPanel) {
		this.verticalPanel = verticalPanel;
	}

	public HorizontalPanel getHorizontalPanelTop() {
		return horizontalPanelTop;
	}

	public void setHorizontalPanelTop(HorizontalPanel horizontalPanelTop) {
		this.horizontalPanelTop = horizontalPanelTop;
	}

	public HorizontalPanel getHorizontalPanelBottom() {
		return horizontalPanelBottom;
	}

	public void setHorizontalPanelBottom(HorizontalPanel horizontalPanelBottom) {
		this.horizontalPanelBottom = horizontalPanelBottom;
	}

	public FlexTable getFlexTableMostActive() {
		return flexTableMostActive;
	}

	public void setFlexTableMostActive(FlexTable flexTableMostActive) {
		this.flexTableMostActive = flexTableMostActive;
	}

	public FlexTable getFlexTableMostOffice() {
		return flexTableMostOffice;
	}

	public void setFlexTableMostOffice(FlexTable flexTableMostOffice) {
		this.flexTableMostOffice = flexTableMostOffice;
	}

	public Label getLabelUserOnline() {
		return labelUserOnline;
	}

	public Label getLabelTotal() {
		return labelTotal;
	}

 
	
	

}
