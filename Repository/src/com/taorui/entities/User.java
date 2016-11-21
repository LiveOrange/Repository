package com.taorui.entities;

import java.util.Date;

/**
 * 账户信息
 */
public class User {

	private int id; // 员工ID
	private String userName;// 员工名称
	private String password;// 密码
	private int job; // 权限
	private String idcard; // 身份证
	private int deptid;// 部门id
	private String address;// 地址
	private int empState;// 在职状态
	private Date regisTime;// 入职时间

	public User() {
		super();
	}

	public User(int id, String userName, int job, int empState) {
		super();
		this.id = id;
		this.userName = userName;
		this.job = job;
		this.empState = empState;
	}

	public User(String userName, String password, int job, String idcard, int deptid, String address) {
		super();
		this.userName = userName;
		this.password = password;
		this.job = job;
		this.idcard = idcard;
		this.deptid = deptid;
		this.address = address;
	}

	public User(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	public User(int id) {
		this.id = id;
	}

	public void setRegisTime(Date regisTime) {
		this.regisTime = regisTime;
	}

	public Date getRegisTime() {
		return regisTime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getJob() {
		return job;
	}

	public void setJob(int job) {
		this.job = job;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public int getDeptid() {
		return deptid;
	}

	public void setDeptid(int deptid) {
		this.deptid = deptid;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getEmpState() {
		return empState;
	}

	public void setEmpState(int empState) {
		this.empState = empState;
	}

}
