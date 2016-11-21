package com.taorui.entities;

import java.util.Date;

public class Client3 extends Client2 {

	private String datas;
	private int curpage;// 当前页
	private int pagesize; // 页大小
	private int total;// 总的记录数
	private int pages;// 总页数
	
	public Client3(int curpage, int pagesize, int total) {

		this.curpage = curpage;
		this.pagesize = pagesize;
		this.total = total;
		// 计算总页数
		this.pages = (this.total - 1) / this.pagesize + 1;
	}

	public String getDatas() {
		return datas;
	}

	public void setDatas(String datas) {
		this.datas = datas;
	}

	public int getCurpage() {
		return curpage;
	}

	public void setCurpage(int curpage) {
		this.curpage = curpage;
	}

	public int getPagesize() {
		return pagesize;
	}

	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public Client3(String clientIndusttry, String loginID, String clientProd, Date clientTime, String clientSource,
			String clientWebsite, String clientWebType, String clientRegion, String clientAddress, int clientNumber,
			String clientCorporat, String clientPhone, String clientCall, String email, String clientFax,
			String clientBackground, String zfb, String taobao, String ensure, int clientOffer, double clientReputat,
			double clientPayment, double clientCapital, int userId, String userName, String clientName,
			String clientPost, String clientDept, String clientfirm, String datas, String clientOrder) {
		super(clientIndusttry, loginID, clientProd, clientTime, clientSource, clientWebsite, clientWebType,
				clientRegion, clientAddress, clientNumber, clientCorporat, clientPhone, clientCall, email, clientFax,
				clientBackground, zfb, taobao, ensure, clientOffer, clientReputat, clientPayment, clientCapital, userId,
				userName, clientName, clientPost, clientDept, clientfirm, clientOrder);
		this.datas = datas;
	}

	public Client3() {
		super();
	}

	public Client3(int clientId, String clientName) {
		super(clientId, clientName);
	}

	public Client3(String clientIndusttry, String loginID, String clientProd, Date clientTime, String clientSource,
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

	public Client3(String clientName) {
		super(clientName);
	}

}
