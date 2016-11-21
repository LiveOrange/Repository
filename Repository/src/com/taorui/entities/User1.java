package com.taorui.entities;

public class User1 extends User {

	private String deptName;
	private String stat;
	private int order;
	private int clientOrder;

	public int getClientOrder() {
		return clientOrder;
	}

	public void setClientOrder(int clientOrder) {
		this.clientOrder = clientOrder;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public User1() {
		super();
	}

	public User1(int id, String userName, String deptName, int job, int empState) {
		super(id, userName, job, empState);
		this.deptName = deptName;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getStat() {
		return stat;
	}

	public void setStat(String stat) {
		this.stat = stat;
	}

}
