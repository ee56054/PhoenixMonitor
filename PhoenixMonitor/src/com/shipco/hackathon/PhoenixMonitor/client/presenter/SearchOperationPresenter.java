package com.shipco.hackathon.PhoenixMonitor.client.presenter;

import java.util.ArrayList;
import java.util.Date;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;
import com.shipco.hackathon.PhoenixMonitor.client.event.LineGraphDayEvent;
import com.shipco.hackathon.PhoenixMonitor.client.event.SearchUserStatEvent;
import com.shipco.hackathon.PhoenixMonitor.shared.UserBean;

public class SearchOperationPresenter implements Presenter {

	public interface Display {
		HasValue<String> getUsername();

		HasValue<Date> getDateFrom();

		HasValue<Date> getDateTo();

		HasValue<String> getOfficeName();

		HasValue<String> getDisplaySize();

		HasClickHandlers getGoButton();

		Widget asWidget();
	}

	private final HandlerManager eventBus;
	private final Display display;

	public SearchOperationPresenter(HandlerManager eventBus, Display display) {
		this.eventBus = eventBus;
		this.display = display;
		bind();
	}

	public void bind() {
		display.getGoButton().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
 
				ArrayList<UserBean> userLists = new ArrayList<UserBean>();

				Date d = new Date();

				java.sql.Date sqlDate = new java.sql.Date(d.getTime());

				UserBean user1 = new UserBean();
				user1.setUserName("john");
				user1.setOfficeCode("BKK");
				user1.setLoginDate(sqlDate);
				user1.setLogoutDate(null);

				UserBean user2 = new UserBean();
				user2.setUserName("joseph");
				user2.setOfficeCode("NYC");
				user2.setLoginDate(sqlDate);
				user2.setLogoutDate(sqlDate);

				UserBean user3 = new UserBean();
				user3.setUserName("john");
				user3.setOfficeCode("BKK");
				user3.setLoginDate(sqlDate);
				user3.setLogoutDate(sqlDate);

				UserBean user4 = new UserBean();
				user4.setUserName("david");
				user4.setOfficeCode("CHA");
				user4.setLoginDate(sqlDate);
				user4.setLogoutDate(sqlDate);

				UserBean user5 = new UserBean();
				user5.setUserName("jack");
				user5.setOfficeCode("HKK");
				user5.setLoginDate(sqlDate);
				user5.setLogoutDate(sqlDate);

				UserBean user6 = new UserBean();
				user6.setUserName("man");
				user6.setOfficeCode("BOS");
				user6.setLoginDate(sqlDate);
				user6.setLogoutDate(null);

				UserBean user7 = new UserBean();
				user7.setUserName("john");
				user7.setOfficeCode("BKK");
				user7.setLoginDate(sqlDate);
				user7.setLogoutDate(sqlDate);

				UserBean user8 = new UserBean();
				user8.setUserName("sam");
				user8.setOfficeCode("IDA");
				user8.setLoginDate(sqlDate);
				user8.setLogoutDate(null);

				userLists.add(user1);
				userLists.add(user2);
				userLists.add(user3);
				userLists.add(user4);
				userLists.add(user5);
				userLists.add(user6);
				userLists.add(user7);
				userLists.add(user8);
 
				
				eventBus.fireEvent(new SearchUserStatEvent(userLists));
				eventBus.fireEvent(new LineGraphDayEvent());
				
				
			}
		});

	}

	@Override
	public void go(HasWidgets container) {
		
		container.add(display.asWidget());
	}
}
