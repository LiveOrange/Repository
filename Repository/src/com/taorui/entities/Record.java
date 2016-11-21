package com.taorui.entities;

public class Record {
	private int id;
	private String data;
	private String record;
	private String jg1;
	private String jg2;

	public void setJg1(String jg1) {
		this.jg1 = jg1;
	}

	public void setJg2(String jg2) {
		this.jg2 = jg2;
	}

	public String getJg1() {
		return jg1;
	}

	public String getJg2() {
		return jg2;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getRecord() {
		return record;
	}

	public void setRecord(String record) {
		this.record = record;
	}

	@Override
	public String toString() {
		return "Record [id=" + id + ", data=" + data + ", record=" + record + "]";
	}

}
