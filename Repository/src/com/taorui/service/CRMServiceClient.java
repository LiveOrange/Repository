package com.taorui.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.taorui.dao.*;
import com.taorui.entities.*;

public class CRMServiceClient {
	private CRMDaoClinent crmdao;
	private CRMDaoContach crmdao1;
	private CRMDaoXmw crmdao2;
	private StockDao stockDao;

	public CRMServiceClient() {
		crmdao = new CRMDaoClinent();
		crmdao1 = new CRMDaoContach();
		crmdao2 = new CRMDaoXmw();
		stockDao = new StockDao();
	}

	// 1、撞单查询
	public int HitSingle(String name) {
		Client1 client1 = new Client1(name);
		List<Client1> client = crmdao.clientQuery(client1);
		if (client != null && client.size() > 0) {
			return 0;
		} else {
			return 1;
		}
	}

	// 2、账单添加查询
	public int insertUser(String clientIndusttry, String loginID, String clientProd, Date clientTime,
			String clientSource, String clientWebsite, String clientWebType, String clientRegion, String clientAddress,
			int clientNumber, String clientCorporat, String clientPhone, String clientCall, String email,
			String clientFax, String clientBackground, String zfb, String taobao, String ensure, int clientOffer,
			double clientReputat, double clientPayment, double clientCapital, int userId, String userName,
			String clientName, String clientPost, String clientDept, String clientfirm, String clientOrder) {

		Client2 client = new Client2(clientIndusttry, loginID, clientProd, clientTime, clientSource, clientWebsite,
				clientWebType, clientRegion, clientAddress, clientNumber, clientCorporat, clientPhone, clientCall,
				email, clientFax, clientBackground, zfb, taobao, ensure, clientOffer, clientReputat, clientPayment,
				clientCapital, userId, userName, clientName, clientPost, clientDept, clientfirm, clientOrder);
		if (crmdao.insertClient(client)) {
			return 1;
		} else {
			return 0;
		}
	}

	// 3、客户查询
	public List<Client3> findAllClient(String id) {
		return crmdao.findAllClient(id);
	}

	// 4、客户查询
	public List<Client3> findAllClient(int id) {
		return crmdao.findAllClient(id);
	}

	// 5、联系人添加
	public String insertContach(String context, String chWay, String attribute, String clientName, String clientIm,
			String clientPhone, String clientCall, String clientFax, int id, String email, String maturity,
			String clientProd) {
		Contach contach = new Contach(context, chWay, attribute, clientName, clientIm, clientPhone, clientCall,
				clientFax, id, email, maturity, clientProd);
		if (crmdao1.insertContach(contach)) {
			return "1";
		} else {
			return "0";
		}
	}

	// 6、联系人查询
	public List<Contach> findAllContach(int id) {
		return crmdao1.contachQuery(id);
	}

	// 7、联系人查询
	public List<Contach> findAllContach(int id, String name) {
		Contach contach = new Contach();
		contach.setId(id);
		contach.setClientName(name);
		return crmdao1.contachQuery(contach);
	}

	// 8、修改联系人
	public String updateContach(String context, String chWay, String attribute, String clientName, String clientIm,
			String clientPhone, String clientCall, String clientFax, int id, String email) {
		Contach contach = new Contach(context, chWay, attribute, clientName, clientIm, clientPhone, clientCall,
				clientFax, id, email);
		if (crmdao1.updateContach(contach)) {
			return "1";
		} else {
			return "0";
		}
	}

	// 9、删除联系人
	public String contachDel(int id) {
		if (crmdao1.contachDel(id)) {
			return "1";
		} else {
			return "0";
		}
	}

	// 10、联系人查询
	public List<Client3> findAllClient(String clientName, String loginID, int id) {
		Client3 contach = new Client3();
		contach.setLoginID(loginID);
		contach.setUserId(id);
		contach.setClientName(clientName);
		return crmdao.findAllClient(contach);
	}

	// 11、联系人查询
	public List<Wareh2> getfindAllClient(int curpage, int pagesize, String data) {
		List<Wareh2> list = null;
		int count = 0;
		if (data != null && !("".equals(data))) {
			count = stockDao.countWareh2(data);

			if (count != 0) {
				list = stockDao.seleWareh(curpage, pagesize, data);
				list.get(0).setPages((count - 1) / pagesize + 1);
				list.get(0).setPagesize(pagesize);
				list.get(0).setCurpage(curpage);
				list.get(0).setTotal(count);
			}
			return list;
		} else {
			count = stockDao.countWareh1();
			if (count != 0) {
				list = stockDao.seleWareh(curpage, pagesize);
				list.get(0).setPages((count - 1) / pagesize + 1);
				list.get(0).setPagesize(pagesize);
				list.get(0).setCurpage(curpage);
				list.get(0).setTotal(count);
			}
			return list;
		}

	}

	// 11、统计
	public PageInfo2<UserCount2> count(int id) {
		PageInfo2<UserCount2> list = new PageInfo2<>();
		list.setSum(crmdao.count(id, "服务中") + crmdao.count(id, "已签单") + crmdao.count(id, "公司公海"));
		list.setWks(crmdao.count(id, "服务中"));
		list.setQdz(crmdao.count(id, "已签单"));
		list.setYwjs(crmdao.count(id, "公司公海"));
		List<Dept> depts = crmdao2.findAllDept();
		List<UserCount2> userCount = new ArrayList<UserCount2>();
		list.setCout(crmdao2.funtcount());
		for (int i = 0; i < depts.size(); i++) {
			UserCount2 userCount2 = new UserCount2();
			userCount2.setData(depts.get(i).getDeptName());
			userCount2.setCount(crmdao2.count(depts.get(i).getDeptID()));
			userCount.add(userCount2);
		}
		list.setData(userCount);
		return list;
	}

}
