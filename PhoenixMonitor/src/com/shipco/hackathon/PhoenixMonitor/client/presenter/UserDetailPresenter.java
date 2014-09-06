package com.shipco.hackathon.PhoenixMonitor.client.presenter;

import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.shipco.hackathon.PhoenixMonitor.client.event.ShowUserDetailEvent;
import com.shipco.hackathon.PhoenixMonitor.client.event.ShowUserDetailEventHandler;
import com.shipco.hackathon.PhoenixMonitor.shared.UserBean;

public class UserDetailPresenter implements Presenter {

	public interface Display {

		Label getUsername();

		Label getFullName();

		Label getDateOfBirth();

		Label getPosition();

		Label getAddress();

		Label getTelephone();

		Label getFax();

		Label getEmail();

		Label getSkype();

		Label getJabber();

		Widget asWidget();

	}

	private UserBean userbean;

	// private final ContactsServiceAsync rpcService;
	private final HandlerManager eventBus;
	private final Display display;

	public UserDetailPresenter(HandlerManager eventBus, Display display) {
		super();
		this.eventBus = eventBus;
		this.display = display;

		bind();
	}

	private void bind() {
		eventBus.addHandler(ShowUserDetailEvent.TYPE,
				new ShowUserDetailEventHandler() {

					@Override
					public void onSearchUserStat(ShowUserDetailEvent event) {
						userbean = event.getUserBeans();
						setUserDetailsFromBean(userbean);
					}
				});
	}

	@Override
	public void go(HasWidgets container) {
		container.add(display.asWidget());

	}

	private void setUserDetailsFromBean(UserBean userbean) {
		display.getUsername().setText(userbean.getUserName().toUpperCase());
		display.getFullName().setText("Ramon Sintateeyakorn");
		display.getDateOfBirth().setText("14 July 1992");
		display.getPosition().setText("Application Developer");
		display.getAddress()
				.setText(
						"14578/258654 Green Tower Building, Rama 4 Road, xxxxxxxx,xxxxxxxx,xxxxxxxx");
		display.getTelephone().setText("02 546 4187");
		display.getFax().setText("02 876 7875");
		display.getEmail().setText("sramon@shipco.com");
		display.getSkype().setText("sti_sramon");
		display.getJabber().setText("xxxxx@jabber.shipco.com");
	}
}
