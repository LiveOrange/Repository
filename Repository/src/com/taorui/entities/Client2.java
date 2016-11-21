package com.taorui.entities;

import java.util.Date;

public class Client2 extends Client1 {


	private String clientIndusttry;// 主营行业
	private String loginID;// Login ID
	private String clientProd;// 客户产品
	private Date clientTime;// 注册时间
	private String clientSource;// 注册来源

	private String clientWebsite;// 客户网址
	private String clientWebType;// 客户网址类型
	private String clientRegion;// 省份地区
	private String clientAddress;// 公司地址
	private int clientNumber;// 员工人数

	private String clientCorporat;// 法人代表
	private String clientPhone;// 电话
	private String clientCall;// 手机
	private String email;// mail
	private String clientFax;// 传真

	private String clientBackground;// 客户背景
	private String zfb;// 是否绑定支付宝
	private String taobao;// 淘宝经营行为
	private String ensure;// 中文经营行为
	private int clientOffer;// 发布offer数

	private double clientReputat;// 授信保证金
	private double clientPayment;// 自缴保证金
	private double clientCapital;// 企业注册资金
	private int userId; // 员工ID
	private String userName;// 员工名称

	private String clientName;// 公司名
	private String clientPost;// 联系人职务
	private String clientDept;// 联系人部门
	private String clientfirm;// 联系人名
	private String clientOrder;//订单状态
	public Client2(String clientIndusttry, String loginID, String clientProd, Date clientTime, String clientSource,
			String clientWebsite, String clientWebType, String clientRegion, String clientAddress, int clientNumber,
			String clientCorporat, String clientPhone, String clientCall, String email, String clientFax,
			String clientBackground, String zfb, String taobao, String ensure, int clientOffer, double clientReputat,
			double clientPayment, double clientCapital, int userId, String userName, String clientName,
			String clientPost, String clientDept, String clientfirm,String clientOrder) {
		super();
		this.clientIndusttry = clientIndusttry;
		this.loginID = loginID;
		this.clientProd = clientProd;
		this.clientTime = clientTime;
		this.clientSource = clientSource;
		this.clientWebsite = clientWebsite;
		this.clientWebType = clientWebType;
		this.clientRegion = clientRegion;
		this.clientAddress = clientAddress;
		this.clientNumber = clientNumber;
		this.clientCorporat = clientCorporat;
		this.clientPhone = clientPhone;
		this.clientCall = clientCall;
		this.email = email;
		this.clientFax = clientFax;
		this.clientBackground = clientBackground;
		this.zfb = zfb;
		this.taobao = taobao;
		this.ensure = ensure;
		this.clientOffer = clientOffer;
		this.clientReputat = clientReputat;
		this.clientPayment = clientPayment;
		this.clientCapital = clientCapital;
		this.userId = userId;
		this.userName = userName;
		this.clientName = clientName;
		this.clientPost = clientPost;
		this.clientDept = clientDept;
		this.clientfirm = clientfirm;
		this.clientOrder=clientOrder;
	}
	public String getClientOrder() {
		return clientOrder;
	}

	public void setClientOrder(String clientOrder) {
		this.clientOrder = clientOrder;
	}

	public Client2() {
		super();
	}

	public Client2(int clientId, String clientName) {
		super(clientId, clientName);
		// TODO Auto-generated constructor stub
	}

	public Client2(String clientName) {
		super(clientName);
		// TODO Auto-generated constructor stub
	}

	public String getEnsure() {
		return ensure;
	}

	public void setEnsure(String ensure) {
		this.ensure = ensure;
	}

	public String getClientfirm() {
		return clientfirm;
	}

	public void setClientfirm(String clientfirm) {
		this.clientfirm = clientfirm;
	}

	public Date getClientTime() {
		return clientTime;
	}

	public void setClientTime(Date clientTime) {
		this.clientTime = clientTime;
	}

	public String getClientIndusttry() {
		return clientIndusttry;
	}

	public void setClientIndusttry(String clientIndusttry) {
		this.clientIndusttry = clientIndusttry;
	}

	public String getLoginID() {
		return loginID;
	}

	public void setLoginID(String loginID) {
		this.loginID = loginID;
	}

	public String getClientProd() {
		return clientProd;
	}

	public void setClientProd(String clientProd) {
		this.clientProd = clientProd;
	}

	public String getClientSource() {
		return clientSource;
	}

	public void setClientSource(String clientSource) {
		this.clientSource = clientSource;
	}

	public String getClientWebsite() {
		return clientWebsite;
	}

	public void setClientWebsite(String clientWebsite) {
		this.clientWebsite = clientWebsite;
	}

	public String getClientWebType() {
		return clientWebType;
	}

	public void setClientWebType(String clientWebType) {
		this.clientWebType = clientWebType;
	}

	public String getClientRegion() {
		return clientRegion;
	}

	public void setClientRegion(String clientRegion) {
		this.clientRegion = clientRegion;
	}

	public String getClientAddress() {
		return clientAddress;
	}

	public void setClientAddress(String clientAddress) {
		this.clientAddress = clientAddress;
	}

	public int getClientNumber() {
		return clientNumber;
	}

	public void setClientNumber(int clientNumber) {
		this.clientNumber = clientNumber;
	}

	public String getClientCorporat() {
		return clientCorporat;
	}

	public void setClientCorporat(String clientCorporat) {
		this.clientCorporat = clientCorporat;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getClientFax() {
		return clientFax;
	}

	public void setClientFax(String clientFax) {
		this.clientFax = clientFax;
	}

	public String getClientBackground() {
		return clientBackground;
	}

	public void setClientBackground(String clientBackground) {
		this.clientBackground = clientBackground;
	}

	public String getZfb() {
		return zfb;
	}

	public void setZfb(String zfb) {
		this.zfb = zfb;
	}

	public String getTaobao() {
		return taobao;
	}

	public void setTaobao(String taobao) {
		this.taobao = taobao;
	}

	public int getClientOffer() {
		return clientOffer;
	}

	public void setClientOffer(int clientOffer) {
		this.clientOffer = clientOffer;
	}

	public double getClientReputat() {
		return clientReputat;
	}

	public void setClientReputat(double clientReputat) {
		this.clientReputat = clientReputat;
	}

	public double getClientPayment() {
		return clientPayment;
	}

	public void setClientPayment(double clientPayment) {
		this.clientPayment = clientPayment;
	}

	public double getClientCapital() {
		return clientCapital;
	}

	public void setClientCapital(double clientCapital) {
		this.clientCapital = clientCapital;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getClientPost() {
		return clientPost;
	}

	public void setClientPost(String clientPost) {
		this.clientPost = clientPost;
	}

	public String getClientDept() {
		return clientDept;
	}

	public void setClientDept(String clientDept) {
		this.clientDept = clientDept;
	}

}
