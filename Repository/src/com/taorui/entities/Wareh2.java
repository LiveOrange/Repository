package com.taorui.entities;

public class Wareh2 extends Wareh {
	private String datas;
	private int curpage;// 当前页
	private int pagesize; // 页大小
	private int total;// 总的记录数
	private int pages;// 总页数

	public Wareh2() {
	}

	public Wareh2(int curpage, int pagesize, int total) {

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

}
