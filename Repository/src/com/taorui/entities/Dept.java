package com.taorui.entities;
/**
 * 部门信息
 */
public class Dept {
	private int deptID;
	private int Remark;
	private String deptName;

	public int getRemark() {
		return Remark;
	}

	public void setRemark(int remark) {
		Remark = remark;
	}

	public int getDeptID() {
		return deptID;
	}

	public void setDeptID(int deptID) {
		this.deptID = deptID;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public Dept(int deptID, String deptName) {
		super();
		this.deptID = deptID;
		this.deptName = deptName;
	}

	public Dept( String deptName, int remark) {
		super();
		this.deptName = deptName;
		Remark = remark;
	}

	public Dept(int deptID, int remark, String deptName) {
		super();
		this.deptID = deptID;
		Remark = remark;
		this.deptName = deptName;
	}

	public Dept() {
		super();
	}

}
