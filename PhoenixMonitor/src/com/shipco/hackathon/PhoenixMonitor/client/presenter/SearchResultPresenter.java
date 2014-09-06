package com.shipco.hackathon.PhoenixMonitor.client.presenter;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.shipco.hackathon.PhoenixMonitor.client.event.SearchUserStatEvent;
import com.shipco.hackathon.PhoenixMonitor.client.event.SearchUserStatEventHanlder;
import com.shipco.hackathon.PhoenixMonitor.client.event.ShowUserDetailEvent;
import com.shipco.hackathon.PhoenixMonitor.client.model.AnchorUserBean;
import com.shipco.hackathon.PhoenixMonitor.shared.UserBean;

public class SearchResultPresenter implements Presenter {

	public interface Display {

		Widget asWidget(); 
		FlexTable getUserResult();

	}

	// private final ContactsServiceAsync rpcService;
	private final HandlerManager eventBus;
	private final Display display;

	private ArrayList<AnchorUserBean> anchors = new ArrayList<AnchorUserBean>();

	public SearchResultPresenter(HandlerManager eventBus, Display display) {
		super();
		this.eventBus = eventBus;
		this.display = display;
		bind();

	}

	private void bind() {

		

		eventBus.addHandler(SearchUserStatEvent.TYPE, new SearchUserStatEventHanlder() {

			@Override
			public void onSearchUserStat(SearchUserStatEvent event) {

				List<UserBean> userLists = event.getUserBeans();
				for (int i = 1; i < userLists.size(); i++) {

					Label userNameValue = new Label(userLists.get(i).getUserName());
					Label officeCodeValue = new Label(userLists.get(i).getOfficeCode());
					Label logoutDateTimeValue = null;
					Label loginDateTimeValue = new Label(DateTimeFormat.getShortDateFormat().format(userLists.get(i).getLoginDate()));
					final AnchorUserBean anchor = new AnchorUserBean("View Details");
					anchor.setUserbean(userLists.get(i));
					// anchor.setHref("12354678");

					try {
						if (userLists.get(i).getLogoutDate() == null) {

							logoutDateTimeValue = new Label("Online");

						} else {

							logoutDateTimeValue = new Label(DateTimeFormat.getShortDateFormat().format(userLists.get(i).getLogoutDate()));

						}
					} catch (Exception e) {
						System.out.println(e.getMessage());
						logoutDateTimeValue = new Label("Online");
					}

					display.getUserResult().setWidget(i, 0, userNameValue);
					display.getUserResult().setWidget(i, 1, officeCodeValue);
					display.getUserResult().setWidget(i, 2, loginDateTimeValue);
					display.getUserResult().setWidget(i, 3, logoutDateTimeValue);
					display.getUserResult().setWidget(i, 4, anchor);

					
					anchor.addClickHandler(new ClickHandler() {

						@Override
						public void onClick(ClickEvent event) {

							ShowUserDetailEvent show = new ShowUserDetailEvent();
							show.setUserBean(anchor.getUserbean());
							eventBus.fireEvent(show);

						}
					});
					
					anchors.add(anchor);
				}
			}
		});

	 

	}

	@Override
	public void go(HasWidgets container) {
		container.add(display.asWidget());

	}

}
