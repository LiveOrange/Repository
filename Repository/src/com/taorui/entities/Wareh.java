package com.taorui.entities;

import java.util.Date;

public class Wareh extends Client5 {
	private String agency;// 库存号
	private String userName;// 入库人
	private String wareh;// 仓库号

	public Wareh(Date regisTime, int id, String agency, String userName, String wareh) {
		super(regisTime, id);
		this.agency = agency;
		this.userName = userName;
		this.wareh = wareh;
	}

	public Wareh() {
	}

	public String getAgency() {
		return agency;
	}

	public void setAgency(String agency) {
		this.agency = agency;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getWareh() {
		return wareh;
	}

	public void setWareh(String wareh) {
		this.wareh = wareh;
	}

}
