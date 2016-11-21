package com.taorui.entities;

import java.util.Date;

public class Contach extends User {

	private int clientId;// 客户id
	private String context;
	private String chWay;
	private Date time;
	private String attribute;
	private String clientName;
	private String clientIm;
	private String clientPhone;
	private String clientCall;
	private String clientFax;
	private String email;
	private String data;
	private String maturity;
	private String clientProd;

	public String getClientProd() {
		return clientProd;
	}

	public void setClientProd(String clientProd) {
		this.clientProd = clientProd;
	}

	public String getMaturity() {
		return maturity;
	}

	public void setMaturity(String maturity) {
		this.maturity = maturity;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public String getChWay() {
		return chWay;
	}

	public void setChWay(String chWay) {
		this.chWay = chWay;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getAttribute() {
		return attribute;
	}

	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getClientIm() {
		return clientIm;
	}

	public void setClientIm(String clientIm) {
		this.clientIm = clientIm;
	}

	public String getClientPhone() {
		return clientPhone;
	}

	public void setClientPhone(String clientPhone) {
		this.clientPhone = clientPhone;
	}

	public String getClientCall() {
		return clientCall;
	}

	public void setClientCall(String clientCall) {
		this.clientCall = clientCall;
	}

	public String getClientFax() {
		return clientFax;
	}

	public void setClientFax(String clientFax) {
		this.clientFax = clientFax;
	}

	public Contach() {
		super();
	}

	public Contach(int id, String userName, int job, int empState) {
		super(id, userName, job, empState);
	}

	public Contach(String userName, String password, int job, String idcard, int deptid, String address) {
		super(userName, password, job, idcard, deptid, address);
	}

	public Contach(String userName, String password) {
		super(userName, password);
	}

	public Contach(String context, String chWay, String attribute, String clientName, String clientIm,
			String clientPhone, String clientCall, String clientFax, int id, String email, String maturity,String clientProd) {
		super(id);
		this.context = context;
		this.chWay = chWay;
		this.attribute = attribute;
		this.clientName = clientName;
		this.clientIm = clientIm;
		this.clientPhone = clientPhone;
		this.clientCall = clientCall;
		this.clientFax = clientFax;
		this.email = email;
		this.maturity = maturity;
		this.clientProd=clientProd;
	}

	public Contach(String context, String chWay, String attribute, String clientName, String clientIm,
			String clientPhone, String clientCall, String clientFax, int id, String email) {
		super(id);
		this.context = context;
		this.chWay = chWay;
		this.attribute = attribute;
		this.clientName = clientName;
		this.clientIm = clientIm;
		this.clientPhone = clientPhone;
		this.clientCall = clientCall;
		this.clientFax = clientFax;
		this.email = email;
	}

}
