package com.trkj.pojo;

import java.util.List;

public class Dept {
	private int deptno;
	private String deame;
	private String loc;
	private List<Emp> list;

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public String getDeame() {
		return deame;
	}

	public void setDeame(String deame) {
		this.deame = deame;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	public List<Emp> getList() {
		return list;
	}

	public void setList(List<Emp> list) {
		this.list = list;
	}

}
