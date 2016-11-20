package com.trkj.pojo;

import java.util.Date;

public class Emp {
	private int empno;
	private String ename;
	private String job;
	private int mgr;
	private Date data;
	private int sal;
	private int comm;
	private int deptno;

	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public int getMgr() {
		return mgr;
	}

	public void setMgr(int mgr) {
		this.mgr = mgr;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public int getSal() {
		return sal;
	}

	public void setSal(int sal) {
		this.sal = sal;
	}

	public int getComm() {
		return comm;
	}

	public void setComm(int comm) {
		this.comm = comm;
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public Emp() {
		super();
	}

	public Emp(int empno, String ename, String job, int mgr, Date data, int sal, int comm, int deptno) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.job = job;
		this.mgr = mgr;
		this.data = data;
		this.sal = sal;
		this.comm = comm;
		this.deptno = deptno;
	}

	@Override
	public String toString() {
		return "Dept [empno=" + empno + ", ename=" + ename + ", job=" + job + ", mgr=" + mgr + ", data=" + data
				+ ", sal=" + sal + ", comm=" + comm + ", deptno=" + deptno + "]";
	}

}
