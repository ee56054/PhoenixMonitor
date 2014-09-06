package com.shipco.hackathon.PhoenixMonitor.client.view;

import java.util.Date;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasValue;
import com.shipco.hackathon.PhoenixMonitor.client.presenter.SearchOperationPresenter;

public class OperationView extends Composite implements
		SearchOperationPresenter.Display {

	@Override
	public HasClickHandlers getGoButton() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HasValue<String> getUsername() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HasValue<Date> getDateFrom() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HasValue<Date> getDateTo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HasValue<String> getOfficeName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HasValue<String> getDisplaySize() {
		// TODO Auto-generated method stub
		return null;
	}

}
