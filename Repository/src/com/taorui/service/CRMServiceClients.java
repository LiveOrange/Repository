package com.taorui.service;

import com.taorui.dao.*;
import com.taorui.entities.Comsea;

public class CRMServiceClients {
	/**
	 * 更新客户联系时间
	 */
	CRMDaoClient crmdao;

	public CRMServiceClients() {
		crmdao = new CRMDaoClient();
	}

	// 1.1、更新手机联系时间
	public boolean deptClientPhone(int id, String order) {
		return crmdao.deptClientPhone(id, order);
	}

	// 1.2、更新山门联系时间
	public boolean deptClientThedoor(int id, String order) {
		return crmdao.deptClientThedoor(id, order);
	}

	public boolean insertComsea(int id, int data) {
		crmdao.updateClientOrder(id, "公司公海");
		Comsea comsea = new Comsea();
		comsea.setClientID(id);
		if (data == 0) {
			comsea.setReason("未进行客户联系，自动流入公海！");
		} else {
			comsea.setReason("两个月未签单，自动流入公海！");
		}
		return crmdao.insertComsea(comsea);
	}

	// 6、客户月跳数加1
	public boolean updataConsum(int id) {
		return crmdao.updataConsum(id);
	}

	// 7、删除公海信息
	public boolean deletConsum(int id) {
		return crmdao.deletConsum(id);
	}

	// 8、修改客户
	public boolean updataClient(int id, String name, int clientid) {

		return crmdao.updataClient(id, name, clientid);
	}

}
