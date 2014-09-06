package com.shipco.hackathon.PhoenixMonitor.shared;

import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.Messages;

public interface SearchOperationMessages extends Messages {

	public static class Util {

		private static SearchOperationMessages searchOperationMessages;

		public static SearchOperationMessages getInstance() {
			if (null == searchOperationMessages) {
				searchOperationMessages = GWT
						.create(SearchOperationMessages.class);
			}
			return searchOperationMessages;
		}
	}

	String username();

	String dateFrom();

	String dateTo();

	String officeName();

	String displaySize();

	String go();

}
