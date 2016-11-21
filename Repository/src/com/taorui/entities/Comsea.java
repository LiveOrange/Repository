package com.taorui.entities;

import java.util.Date;

public class Comsea extends Client2{
	private int comseaID;// 公海id
	private int clientID;// 用户id
	private String reason;// 公海原因
	private Date data;// 公海时间

	public int getComseaID() {
		return comseaID;
	}

	public void setComseaID(int comseaID) {
		this.comseaID = comseaID;
	}

	public int getClientID() {
		return clientID;
	}

	public void setClientID(int clientID) {
		this.clientID = clientID;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Comsea(int comseaID, int clientID, String reason, Date data) {
		super();
		this.comseaID = comseaID;
		this.clientID = clientID;
		this.reason = reason;
		this.data = data;
	}

	public Comsea() {
		super();
	}

}