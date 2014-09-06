package com.shipco.hackathon.PhoenixMonitor.client.view;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.shipco.hackathon.PhoenixMonitor.client.presenter.UserDetailPresenter;

public class UserDetailView extends Composite implements
		UserDetailPresenter.Display {

	private Grid mainPanel = new Grid(3, 1);
	private Grid contactInformationPanel = new Grid(2, 1);
	private VerticalPanel titlePanel = new VerticalPanel();
	private FlexTable userInformationTable = new FlexTable();
	private FlexTable userContactInformationTable = new FlexTable();

	private Label usernameLabel = new Label("USERNAME");
	private Label fullNameLabel = new Label("FULL NAME");
	private Label dateOfBirthLabel = new Label("DATE OF BIRTH");
	private Label positionLabel = new Label("POSITION");
	private Label addressLabel = new Label("ADDRESS");

	private Label username = new Label();
	private Label fullName = new Label();
	private Label dateOfBirth = new Label();
	private Label position = new Label();
	private Label address = new Label();

	private Label contactInformationLabel = new Label("CONTACT INFORMATION");
	private Label telephoneLabel = new Label("TELEPHONE");
	private Label faxLabel = new Label("FAX");
	private Label emailLabel = new Label("EMAIL");
	private Label skypeLabel = new Label("SKYPE");
	private Label jabberLabel = new Label("JABBER");

	private Label telephone = new Label();
	private Label fax = new Label();
	private Label email = new Label();
	private Label skype = new Label();
	private Label jabber = new Label();

	public UserDetailView() {
		setWidget();
		initStyle();
		initWidget(mainPanel);
	}

	private void setWidget() {
		mainPanel.setWidget(0, 0, titlePanel);
		mainPanel.setWidget(1, 0, userInformationTable);
		mainPanel.setWidget(2, 0, contactInformationPanel);

		titlePanel.add(usernameLabel);
		titlePanel.add(username);

		setUserInformationTable();
		setUserContactInfoTable();
	}

	private void setUserInformationTable() {
		int row = 0;
		int column = 0;

		userInformationTable.setWidget(row, column++, fullNameLabel);
		userInformationTable.setWidget(row, column++, dateOfBirthLabel);
		userInformationTable.setWidget(row, column++, positionLabel);

		row++;
		column = 0;

		userInformationTable.setWidget(row, column++, fullName);
		userInformationTable.setWidget(row, column++, dateOfBirth);
		userInformationTable.setWidget(row, column++, position);

		row++;
		column = 0;

		userInformationTable.setWidget(row, column++, addressLabel);

		row++;
		column = 0;

		userInformationTable.setWidget(row, column, address);

		userInformationTable.getFlexCellFormatter().setColSpan(row, column, 3);
	}

	private void setUserContactInfoTable() {
		contactInformationPanel.setWidget(0, 0, contactInformationLabel);
		contactInformationPanel.setWidget(1, 0, userContactInformationTable);

		int row = 0;
		int column = 0;

		userContactInformationTable.setWidget(row, column++, telephoneLabel);
		userContactInformationTable.setWidget(row, column++, faxLabel);
		userContactInformationTable.setWidget(row, column++, emailLabel);

		row++;
		column = 0;

		userContactInformationTable.setWidget(row, column++, telephone);
		userContactInformationTable.setWidget(row, column++, fax);
		userContactInformationTable.setWidget(row, column++, email);

		row++;
		column = 0;

		userContactInformationTable.setWidget(row, column++, skypeLabel);
		userContactInformationTable.setWidget(row, column++, jabberLabel);

		row++;
		column = 0;

		userContactInformationTable.setWidget(row, column++, skype);
		userContactInformationTable.setWidget(row, column++, jabber);
	}

	private void initStyle() {

		mainPanel.setWidth("100%");
		mainPanel.setStyleName("header_table");
		mainPanel.getCellFormatter().setHorizontalAlignment(2, 0,
				HasHorizontalAlignment.ALIGN_CENTER);

		contactInformationPanel.setStyleName("contact_table");
		contactInformationPanel.getCellFormatter().setHorizontalAlignment(0, 0,
				HasHorizontalAlignment.ALIGN_CENTER);
		contactInformationPanel.getRowFormatter().setStyleName(0,
				"contact_table_title");

		userContactInformationTable.getElement().getStyle()
				.setPadding(20, Unit.PX);
		userContactInformationTable.setWidth("100%");

		usernameLabel.setStyleName("user_label_font");
		username.setStyleName("title_font");

		fullNameLabel.setStyleName("user_label_font");
		dateOfBirthLabel.setStyleName("user_label_font");
		positionLabel.setStyleName("user_label_font");
		addressLabel.setStyleName("user_label_font");

		telephoneLabel.setStyleName("contact_label_font");
		faxLabel.setStyleName("contact_label_font");
		emailLabel.setStyleName("contact_label_font");
		skypeLabel.setStyleName("contact_label_font");
		jabberLabel.setStyleName("contact_label_font");

		fullName.setStyleName("user_details_font");
		dateOfBirth.setStyleName("user_details_font");
		position.setStyleName("user_details_font");
		address.setStyleName("user_details_font");

		telephone.setStyleName("contact_details_font");
		fax.setStyleName("contact_details_font");
		email.setStyleName("contact_details_font");
		skype.setStyleName("contact_details_font");
		jabber.setStyleName("contact_details_font");

		contactInformationLabel.setStyleName("subtitle_font");

	}

	@Override
	public Label getUsername() {
		return username;
	}

	@Override
	public Label getFullName() {
		return fullName;
	}

	@Override
	public Label getDateOfBirth() {
		return dateOfBirth;
	}

	@Override
	public Label getPosition() {
		return position;
	}

	@Override
	public Label getAddress() {
		return address;
	}

	@Override
	public Label getTelephone() {
		return telephone;
	}

	@Override
	public Label getFax() {
		return fax;
	}

	@Override
	public Label getEmail() {
		return email;
	}

	@Override
	public Label getSkype() {
		return skype;
	}

	@Override
	public Label getJabber() {
		return jabber;
	}
}
