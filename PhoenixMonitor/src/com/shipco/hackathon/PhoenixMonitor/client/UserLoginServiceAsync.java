package com.shipco.hackathon.PhoenixMonitor.client;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.shipco.hackathon.PhoenixMonitor.shared.TimeBean;

/**
 * The async counterpart of <code>UserLoginService</code>.
 */
public interface UserLoginServiceAsync {
	void getMinuteData(AsyncCallback<List<TimeBean>> callback) throws Exception;

	void getHourData(AsyncCallback<List<TimeBean>> callback) throws Exception;

	void getDayData(AsyncCallback<List<TimeBean>> callback) throws Exception;

	void getLastUserLogin(AsyncCallback<List<TimeBean>> callback);

	void selectTotalOnline(AsyncCallback<TimeBean> callback);

	void getEmailOfSearchTrackingDocumentHistory(List<EDocsDocumentHistoryInfoBean> documentHistoryInfoBeans, AsyncCallback<List<EDocsDocumentHistoryInfoBean>> callback);
}
