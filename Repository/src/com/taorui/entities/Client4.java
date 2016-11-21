package com.taorui.entities;

import java.util.*;

public class Client4 extends Client2 {
	private Date phoneTime;
	private Date thedoorTime;

	public Date getPhoneTime() {
		return phoneTime;
	}

	public void setPhoneTime(Date phoneTime) {
		this.phoneTime = phoneTime;
	}

	public Date getThedoorTime() {
		return thedoorTime;
	}

	public void setThedoorTime(Date thedoorTime) {
		this.thedoorTime = thedoorTime;
	}

	public Client4() {
		super();
	}

	public Client4(int clientId, String clientName) {
		super(clientId, clientName);
	}

	public Client4(String clientIndusttry, String loginID, String clientProd, Date clientTime, String clientSource,
			String clientWebsite, String clientWebType, String clientRegion, String clientAddress, int clientNumber,
			String clientCorporat, String clientPhone, String clientCall, String email, String clientFax,
			String clientBackground, String zfb, String taobao, String ensure, int clientOffer, double clientReputat,
			double clientPayment, double clientCapital, int userId, String userName, String clientName,
			String clientPost, String clientDept, String clientfirm, String clientOrder) {
		super(clientIndusttry, loginID, clientProd, clientTime, clientSource, clientWebsite, clientWebType,
				clientRegion, clientAddress, clientNumber, clientCorporat, clientPhone, clientCall, email, clientFax,
				clientBackground, zfb, taobao, ensure, clientOffer, clientReputat, clientPayment, clientCapital, userId,
				userName, clientName, clientPost, clientDept, clientfirm, clientOrder);
	}

	public Client4(String clientName) {
		super(clientName);
	}

}
