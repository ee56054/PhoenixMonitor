package com.shipco.hackathon.PhoenixMonitor.client.view;

import java.io.IOException;
import java.util.Date;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.text.shared.Renderer;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.ValueListBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.datepicker.client.DateBox;
import com.google.gwt.user.datepicker.client.DatePicker;
import com.shipco.hackathon.PhoenixMonitor.client.presenter.SearchOperationPresenter;
import com.shipco.hackathon.PhoenixMonitor.shared.SearchOperationMessages;

public class SearchOperationView extends Composite implements
		SearchOperationPresenter.Display {

	private SearchOperationMessages searchOperationMessages;
	private DecoratorPanel decPanel = new DecoratorPanel();

	private FlexTable mainFlexTable;
	private Label usernameLabel;
	private Label dateFromLabel;
	private Label dateToLabel;
	private Label officeNameLabel;
	private Label displaySizeLabel;
	private TextBox usernameTextBox;
	private DatePicker dateFromDatePicker;
	private DatePicker dateToDatePicker;
	private ValueListBox<String> officeNameValueListBox;
	private ValueListBox<String> displaySizeValueListBox;
	private Button goButton;
	
	
	private DateBox dateBoxFromDate;
	private DateBox dateBoxToDate;
	
	public SearchOperationView() {
		init();
		setWidget();
		setStyle();
	}

	private void init() {
		class StringBasicRenderer implements Renderer<String> {

			@Override
			public String render(String object) {
				return object;
			}

			@Override
			public void render(String object, Appendable appendable)
					throws IOException {
				String s = render(object);
				appendable.append(s);
			}

		}
		searchOperationMessages = SearchOperationMessages.Util.getInstance();
	 
		usernameLabel = new Label(searchOperationMessages.username());
		dateFromLabel = new Label(searchOperationMessages.dateFrom());
		dateToLabel = new Label(searchOperationMessages.dateTo());
		officeNameLabel = new Label(searchOperationMessages.officeName());
		mainFlexTable = new FlexTable();
		usernameTextBox = new TextBox();
		dateFromDatePicker = new DatePicker();

	      // Create a DateBox
	      DateTimeFormat dateFormat = DateTimeFormat.getFormat("MM/dd/yyyy");
	      dateBoxFromDate = new DateBox();
	      dateBoxFromDate.setFormat(new DateBox.DefaultFormat(dateFormat));
	
	      // Create a DateBox 
	      dateBoxToDate = new DateBox();
	      dateBoxToDate.setFormat(new DateBox.DefaultFormat(dateFormat));
	      
		officeNameValueListBox = new ValueListBox<String>(
				new StringBasicRenderer());
		displaySizeValueListBox = new ValueListBox<String>(new StringBasicRenderer());
		displaySizeValueListBox.setValue("Test1");
		displaySizeValueListBox.setValue("Test2",true);
		displaySizeValueListBox.setValue("Test3");
		
		
		
		goButton = new Button("Go");
		initWidget(decPanel);
	}

	private void setWidget() {
		int rIndex = 0;
		int cIndex = 0;

		mainFlexTable.setWidget(rIndex, cIndex++, usernameLabel);
		mainFlexTable.setWidget(rIndex, cIndex++, usernameTextBox);
		mainFlexTable.setWidget(rIndex, cIndex++, dateFromLabel);
		mainFlexTable.setWidget(rIndex, cIndex++, dateBoxFromDate);
		mainFlexTable.setWidget(rIndex, cIndex++, dateToLabel);
		mainFlexTable.setWidget(rIndex, cIndex++, dateBoxToDate);

		rIndex++; // rIndex = 1
		cIndex = 0;

		mainFlexTable.setWidget(rIndex, cIndex++, officeNameLabel);
		mainFlexTable.setWidget(rIndex, cIndex++, officeNameValueListBox);
		mainFlexTable.setWidget(rIndex, cIndex++, displaySizeLabel);
		mainFlexTable.setWidget(rIndex, cIndex++, displaySizeValueListBox);
		mainFlexTable.setWidget(rIndex, cIndex++, new HTML());
		mainFlexTable.setWidget(rIndex, cIndex++, goButton);
		

	    decPanel.setWidget(mainFlexTable);
	}

	private void setStyle() {
		// TODO Auto-generated method stub

	}

	@Override
	public HasValue<String> getUsername() {
		return usernameTextBox;
	}

	@Override
	public HasValue<Date> getDateFrom() {
		return dateFromDatePicker;
	}

	@Override
	public HasValue<Date> getDateTo() {
		return dateToDatePicker;
	}

	@Override
	public HasValue<String> getOfficeName() {
		return officeNameValueListBox;
	}

	@Override
	public HasValue<String> getDisplaySize() {
		return displaySizeValueListBox;
	}

	@Override
	public HasClickHandlers getGoButton() {
		return goButton;
	}

	@Override
	public Widget asWidget() {
		return this;
	}
}
