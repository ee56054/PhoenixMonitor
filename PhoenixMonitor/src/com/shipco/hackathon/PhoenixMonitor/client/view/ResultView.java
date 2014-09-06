package com.shipco.hackathon.PhoenixMonitor.client.view;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Label;
import com.shipco.hackathon.PhoenixMonitor.client.presenter.SearchResultPresenter;

public class ResultView extends Composite implements SearchResultPresenter.Display {


//	final FlexTable userTable = new FlexTable();
//	final FlexTable userHeader = new FlexTable();
	final FlexTable userResult = new FlexTable();

	//
	// public interface Show {
	// List<UserBean> getListUsers();
	//
	// }

	public ResultView() {

		Label userName = new Label("UserName");
		Label officeCode = new Label("OfficeCode");
		Label loginDateTime = new Label("Login Date /Time");
		Label logoutDateTime = new Label("Logout Date/Time");
		Label viewDetail = new Label("ViewDetail");

		userName.setStyleName("label");
		officeCode.setStyleName("label");
		loginDateTime.setStyleName("label");
		logoutDateTime.setStyleName("label");

		userResult.setWidget(0, 0, userName);
		userResult.setWidget(0, 1, officeCode);
		userResult.setWidget(0, 2, loginDateTime);
		userResult.setWidget(0, 3, logoutDateTime);
		userResult.setWidget(0, 4, viewDetail);
		userResult.setStyleName("flexTable");
		userResult.getElement().getStyle().setWidth(50, Unit.PC);

//		userTable.setWidget(0, 0, userHeader);
//		userTable.setWidget(1, 0, userResult);
//		userTable.setStyleName("CSSTableGenerator");

		initWidget(userResult);

	}

 

	@Override
	public FlexTable getUserResult() {
		return userResult;
	}

}
