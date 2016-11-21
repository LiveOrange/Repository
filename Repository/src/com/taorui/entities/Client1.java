package com.taorui.entities;

public class Client1 {
	private int clientId; // 客户ID
	private String ClientName;// 公司名

	public Client1() {
		super();
	}

	public Client1(int clientId, String clientName) {
		super();
		this.clientId = clientId;
		ClientName = clientName;
	}

	public Client1(String clientName) {
		super();
		ClientName = clientName;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public String getClientName() {
		return ClientName;
	}

	public void setClientName(String clientName) {
		ClientName = clientName;
	}

}
