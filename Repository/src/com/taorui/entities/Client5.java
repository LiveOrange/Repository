package com.taorui.entities;

import java.util.Date;

public class Client5 {
	private String CompName;// 公司名
	private String CompCateg;// 公司类别
	private String LoginID;// LoginID
	private String Category;// 商品类别
	private Date RegisTime;// 登记时间
	
	private String CommoSourc;// 商品来源
	private String CommoName;// 商品名称
	private Date OutTime;// 预计出库日期
	private String ProArea;// 省份地区
	private String CommoAdd;// 公司地址
	
	private String Phone;// 电话
	private String MobPhone;// 手机
	private String Email;// E-mail
	private String Fax;// 传真
	private String ClienBound;// 客户背景
	
	private String ZFB;// 是否绑定支付宝
	private String ChAtion;// 中文经营行为
	private String taob;// 淘宝经营行为
	private String AgencyFee;// 货运单号
	private String CredMarg;// 规格
	
	private double Money;// 金额
	private double Amount;// 总金额
	private String CustName;// 客户姓名
	private int Quantity;// 商品数量
	private int Commodity;// 单个商品重量
	private int State;
	private int id;
	private int sum;
	
	public Client5(Date regisTime, int id) {
		super();
		RegisTime = regisTime;
		this.id = id;
	}

	public String getCompName() {
		return CompName;
	}

	public void setCompName(String compName) {
		CompName = compName;
	}

	public String getCompCateg() {
		return CompCateg;
	}

	public void setCompCateg(String compCateg) {
		CompCateg = compCateg;
	}

	public String getLoginID() {
		return LoginID;
	}

	public void setLoginID(String loginID) {
		LoginID = loginID;
	}

	public String getCategory() {
		return Category;
	}

	public void setCategory(String category) {
		Category = category;
	}

	public Date getRegisTime() {
		return RegisTime;
	}

	public void setRegisTime(Date regisTime) {
		RegisTime = regisTime;
	}

	public String getCommoSourc() {
		return CommoSourc;
	}

	public void setCommoSourc(String commoSourc) {
		CommoSourc = commoSourc;
	}

	public String getCommoName() {
		return CommoName;
	}

	public void setCommoName(String commoName) {
		CommoName = commoName;
	}

	public Date getOutTime() {
		return OutTime;
	}

	public void setOutTime(Date outTime) {
		OutTime = outTime;
	}

	public String getProArea() {
		return ProArea;
	}

	public void setProArea(String proArea) {
		ProArea = proArea;
	}

	public String getCommoAdd() {
		return CommoAdd;
	}

	public void setCommoAdd(String commoAdd) {
		CommoAdd = commoAdd;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public String getMobPhone() {
		return MobPhone;
	}

	public void setMobPhone(String mobPhone) {
		MobPhone = mobPhone;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getFax() {
		return Fax;
	}

	public void setFax(String fax) {
		Fax = fax;
	}

	public String getClienBound() {
		return ClienBound;
	}

	public void setClienBound(String clienBound) {
		ClienBound = clienBound;
	}

	public String getZFB() {
		return ZFB;
	}

	public void setZFB(String zFB) {
		ZFB = zFB;
	}

	public String getChAtion() {
		return ChAtion;
	}

	public void setChAtion(String chAtion) {
		ChAtion = chAtion;
	}

	public String getTaob() {
		return taob;
	}

	public void setTaob(String taob) {
		this.taob = taob;
	}

	public String getAgencyFee() {
		return AgencyFee;
	}

	public void setAgencyFee(String agencyFee) {
		AgencyFee = agencyFee;
	}

	public String getCredMarg() {
		return CredMarg;
	}

	public void setCredMarg(String credMarg) {
		CredMarg = credMarg;
	}

	public double getMoney() {
		return Money;
	}

	public void setMoney(double money) {
		Money = money;
	}

	public double getAmount() {
		return Amount;
	}

	public void setAmount(double amount) {
		Amount = amount;
	}

	public String getCustName() {
		return CustName;
	}

	public void setCustName(String custName) {
		CustName = custName;
	}

	public int getQuantity() {
		return Quantity;
	}

	public void setQuantity(int quantity) {
		Quantity = quantity;
	}

	public int getCommodity() {
		return Commodity;
	}

	public void setCommodity(int commodity) {
		Commodity = commodity;
	}

	public int getState() {
		return State;
	}

	public void setState(int state) {
		State = state;
	}

	public Client5() {
		super();
	}

	public Client5(String compName, String loginID, Date regisTime, String commoSourc, String commoName,
			String custName) {
		super();
		CompName = compName;
		LoginID = loginID;
		RegisTime = regisTime;
		CommoSourc = commoSourc;
		CommoName = commoName;
		CustName = custName;
	}

	public Client5(String compName, String compCateg, String loginID, String category, Date regisTime,
			String commoSourc, String commoName, Date outTime, String proArea, String commoAdd, String phone,
			String mobPhone, String email, String fax, String clienBound, String zFB, String chAtion, String taob,
			String agencyFee, String credMarg, double money, double amount, String custName, int quantity,
			int commodity) {
		super();
		CompName = compName;
		CompCateg = compCateg;
		LoginID = loginID;
		Category = category;
		RegisTime = regisTime;
		CommoSourc = commoSourc;
		CommoName = commoName;
		OutTime = outTime;
		ProArea = proArea;
		CommoAdd = commoAdd;
		Phone = phone;
		MobPhone = mobPhone;
		Email = email;
		Fax = fax;
		ClienBound = clienBound;
		ZFB = zFB;
		ChAtion = chAtion;
		this.taob = taob;
		AgencyFee = agencyFee;
		CredMarg = credMarg;
		Money = money;
		Amount = amount;
		CustName = custName;
		Quantity = quantity;
		Commodity = commodity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	
}
