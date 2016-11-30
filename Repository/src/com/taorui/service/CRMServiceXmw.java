package com.taorui.service;

import java.util.*;

import com.taorui.dao.CRMDaoXmw;
import com.taorui.dao.DAOException;
import com.taorui.entities.Dept;
import com.taorui.entities.PageInfo;
import com.taorui.entities.User;
import com.taorui.entities.User1;

public class CRMServiceXmw {
	private CRMDaoXmw crmdao;

	public CRMServiceXmw() {
		crmdao = new CRMDaoXmw();
	}

	// 1、部门添加
	public String insertDept(String dptName) {
		Dept detp = new Dept(dptName, 1);
		if (dptName != null && !("".equals(dptName)) && crmdao.insertDept(detp)) {
			return "部门添加成功！";
		} else {
			return "部门添加失败！";
		}
	}

	// 2、部门查询
	public List<Dept> findAllDept() {
		return crmdao.findAllDept();
	}

	// 3、部门分页查询
	public PageInfo<Dept> getDept(int curpage, int pagesize) {
		List<Dept> list = null;
		int count = 0;
		list = crmdao.getDept(curpage, pagesize);
		count = crmdao.count();
		return new PageInfo<Dept>(curpage, pagesize, count, list);
	}

	// 4、部门修改
	public String updateDept(String dptName, int detID) {
		Dept detp = new Dept(detID, dptName);
		if (crmdao.updateDept(detp)) {
			return "部门修改成功！";
		} else {
			return "部门修改失败！";
		}
	}

	// 5、部门删除
	public String deptDel(String dptName, int detID) {
		Dept detp = new Dept(detID, 0, dptName);
		if (crmdao.deptDel(detp)) {
			return "部门删除成功！";
		} else {
			return "部门删除失败！";
		}
	}

	// 6、账户添加
	public String insertUser(String userName, String password, int job, String idcard, int deptid, String address) {
		User user = new User(userName, password, job, idcard, deptid, address);
		user.setEmpState(1);
		user.setRegisTime(new Date());
		if (crmdao.insertUser(user)) {
			return "员工录入成功！";
		} else {
			return "员工录入失败！";
		}
	}

	// 6、账户登录
	public User user(String userName, String password) {
		User user = new User(userName, password);
		List<User> list = crmdao.usersQuery(user);
		if (list != null && list.size() > 0) {
			return list.get(0);
		} else {
			return null;
		}
	}

	// 7、账户查询
	public PageInfo<User1> getUser(int curpage, int pagesize) {
		List<User1> list = null;
		int count = 0;
		list = crmdao.findUser1ByPage(curpage, pagesize);
		count = crmdao.UserCount();
		return new PageInfo<User1>(curpage, pagesize, count, list);
	}

	// 8、账户修改
	public String updateUser(int id, String userName, String deptName, int job, int empState) {
		User1 user = new User1(id, userName, deptName, job, empState);
		int i = -1;
		List<Dept> dept = crmdao.findAllDept();
		for (Dept list : dept) {
			if (list.getDeptName().equals(user.getDeptName())) {
				i = list.getDeptID();
				break;
			}
		}
		if (i != -1) {
			user.setDeptid(i);
			if (crmdao.updateUser(user)) {
				return "员工信息修改成功！";
			} else {
				return "员工信息修改失败！";
			}
		} else {
			return "员工信息修改失败！该部门不存在！";
		}
	}

	// 9、账户查询
	public List<User1> finClientByPage() {
		List<User1> list = null;
		list = crmdao.finClientByPage();
		return list;
	}

	// 10、查询
	public List<User1> finClientByPages() {
		return crmdao.finClientByPage();
	}
}
