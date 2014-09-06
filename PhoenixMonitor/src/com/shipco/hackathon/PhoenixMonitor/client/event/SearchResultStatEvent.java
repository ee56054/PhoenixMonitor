package com.shipco.hackathon.PhoenixMonitor.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class SearchResultStatEvent extends
		GwtEvent<SearchResultStatEventHandler> {

	public static Type<SearchResultStatEventHandler> TYPE = new Type<SearchResultStatEventHandler>();

	@Override
	public Type<SearchResultStatEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(SearchResultStatEventHandler handler) {

		handler.onSearchUserStat(this);
	}

}
