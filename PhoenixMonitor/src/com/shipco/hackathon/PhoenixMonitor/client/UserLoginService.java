package com.shipco.hackathon.PhoenixMonitor.client;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.shipco.hackathon.PhoenixMonitor.shared.TimeBean;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("greet")
public interface UserLoginService extends RemoteService {
	List<TimeBean> getMinuteData() throws Exception;

	List<TimeBean> getHourData() throws Exception;

	List<TimeBean> getDayData() throws Exception; 
	
	List<TimeBean> getLastUserLogin() throws Exception;
	
	TimeBean selectTotalOnline() throws Exception;
	
	public List<EDocsDocumentHistoryInfoBean> getEmailOfSearchTrackingDocumentHistory(
			 List<EDocsDocumentHistoryInfoBean> documentHistoryInfoBeans) throws BusinessException,
			FatalException;

	
}