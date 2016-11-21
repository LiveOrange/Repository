package com.taorui.entities;

import java.util.List;

/**
 * 分页信息
 */
public class PageInfo2<T> {

	private int sum;
	private int wks;
	private int qdz;
	private int ywjs;
	private int yjs;
	private int cout;
	private List<T> data;

	public int getCout() {
		return cout;
	}

	public void setCout(int cout) {
		this.cout = cout;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public int getWks() {
		return wks;
	}

	public void setWks(int wks) {
		this.wks = wks;
	}

	public int getQdz() {
		return qdz;
	}

	public void setQdz(int qdz) {
		this.qdz = qdz;
	}

	public int getYwjs() {
		return ywjs;
	}

	public void setYwjs(int ywjs) {
		this.ywjs = ywjs;
	}

	public int getYjs() {
		return yjs;
	}

	public void setYjs(int yjs) {
		this.yjs = yjs;
	}

}
