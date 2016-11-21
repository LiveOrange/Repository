package com.taorui.service;

import java.util.*;
import com.taorui.dao.*;
import com.taorui.entities.*;

public class CRMServiceContact {
	private CRMDaoContact crm;

	public CRMServiceContact() {
		crm = new CRMDaoContact();
	}

	// 3、已单数
	public int contactOrder(int id) {
		return crm.contactOrder(id);
	}

	// 3、本月接单数
	public List<User1> usersQuery(int id) {
		List<User1> list = crm.usersQuery(id);
		if (list != null && list.size() > 0) {
			list.get(0).setClientOrder(this.contactOrder(id));
			return list;
		} else {
			return null;
		}
	}

	// 4、分页查询
	public PageInfo<Comsea> getUser(int curpage, int pagesize, String logid, String id, String name, String prod,
			int a,int x,String username) {
		Comsea comsea = new Comsea();
		comsea.setLoginID(logid);
		int id1 ;
		if(id!=null&&!id.trim().equals("")){
			 id1= Integer.parseInt(id);
		}else {
			 id1=0;
		}
		comsea.setClientId(id1);
		comsea.setClientName(name);
		comsea.setClientProd(prod);
		List<Comsea> list = null;
		int count = 0;
		count = crm.finClientCount(comsea);
		System.out.println("count:" + count);
		list = crm.finClientByPage(comsea, curpage, pagesize);
		return new PageInfo<Comsea>(curpage, pagesize, count, list, a, logid, id1, name, prod,x,username);
	}

	
	public PageInfo<Comsea> getUser(int curpage, int pagesize, int a,int x,String username) {
		List<Comsea> list = null;
		int count = 0;
		count = crm.contactCount();
		list = crm.finClientByPage(curpage, pagesize);
		return new PageInfo<Comsea>(curpage, pagesize, count, list, a,x,username);
	}
}
