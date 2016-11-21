package com.taorui.entities;

import java.util.List;

/**
 * 分页信息
 */
public class PageInfo<T> {


	private int curpage;// 当前页
	private int pagesize; // 页大小
	private int total;// 总的记录数
	private int pages;// 总页数
	private int a;
	private String logid;
	private int id;
	private String name;
	private String username;
	private String prod;
	private List<T> data;// 当前页的数据集合
	private int x;
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}
	public PageInfo(int curpage, int pagesize, int total, List<T> data,
								 int a,String logid,int id ,
								 String name,String prod,int x ,String username) {
		super();
		this.curpage = curpage;
		this.pagesize = pagesize;
		this.total = total;
		this.data = data;
		this.a = a;
		// 计算总页数
		this.pages = (this.total - 1) / this.pagesize + 1;
		this.logid=logid;
		this.id=id;
		this.name=name;
		this.prod=prod;
		this.x=x;
		this.username=username;
	}
	
	public PageInfo() {
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public String getLogid() {
		return logid;
	}

	public void setLogid(String logid) {
		this.logid = logid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProd() {
		return prod;
	}

	public void setProd(String prod) {
		this.prod = prod;
	}

	public PageInfo(int curpage, int pagesize, int total, List<T> data, int a,int x,String username) {
		super();
		this.curpage = curpage;
		this.pagesize = pagesize;
		this.total = total;
		this.data = data;
		this.a = a;
		// 计算总页数
		this.pages = (this.total - 1) / this.pagesize + 1;
		this.x=x;
		this.username=username;
	}

	public PageInfo(int curpage, int pagesize, int total, List<T> data) {
		super();
		this.curpage = curpage;
		this.pagesize = pagesize;
		this.total = total;
		this.data = data;
		this.a = a;
		// 计算总页数
		this.pages = (this.total - 1) / this.pagesize + 1;
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

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

}
