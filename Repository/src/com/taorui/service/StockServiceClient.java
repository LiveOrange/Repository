package com.taorui.service;

import java.util.Date;
import java.util.List;

import com.taorui.dao.*;
import com.taorui.entities.Client5;
import com.taorui.entities.OrdersSum;
import com.taorui.entities.Wareh;

public class StockServiceClient {
	private StockDao stock;

	public StockServiceClient() {
		stock = new StockDao();
	}

	public int insertClient(String compName, String credMarg, String loginID, String category, Date regisTime,
			String commoSourc, String commoName, Date outTime, String commoAdd, String phone, String mobPhone,
			String email, String fax, String clienBound, String zFB, String chAtion, String taob, String agencyFee,
			double money, double amount, String compCateg, String custName, int quantity, int commodity,
			String proArea) {
		Client5 client = new Client5(compName, compCateg, loginID, category, regisTime, commoSourc, commoName, outTime,
				proArea, commoAdd, phone, mobPhone, email, fax, clienBound, zFB, chAtion, taob, agencyFee, credMarg,
				money, amount, custName, quantity, commodity);
		client.setState(1);
		return stock.insertClient(client) ? 1 : 0;
	}

	public List<Client5> seleClient(String compName, String loginID, Date regisTime, String commoSourc,
			String commoName, String custName) {
		Client5 client5 = new Client5(compName, loginID, regisTime, commoSourc, commoName, custName);
		return stock.seleClient(client5);
	}

	public int insertWareh(String agency, String wareh, String userName, Date regisTime, int id) {
		Wareh ware = new Wareh(regisTime, id, agency, userName, wareh);
		stock.updatWareh(id);
		return stock.insertWareh(ware) ? 1 : 0;

	}

	public int updatWarehs(int id) {
		return stock.updatWarehs(id) ? 1 : 0;
	}

	public OrdersSum countWareh() {
		OrdersSum ordersSum = new OrdersSum();
		ordersSum.setSum(stock.countWareh1());
		ordersSum.setSum1(stock.countWareh2("1号仓库"));
		ordersSum.setSum2(stock.countWareh2("2号仓库"));
		ordersSum.setSum3(stock.countWareh2("3号仓库"));
		ordersSum.setSum4(stock.countWareh2("4号仓库"));
		ordersSum.setSum5(stock.countWareh2("5号仓库"));
		ordersSum.setSum6(stock.countWareh2("6号仓库"));
		return ordersSum;
	}

	public int updatWare(String data, int id) {
		return stock.updatWare(id, data) ? 1 : 0;
	}
}
