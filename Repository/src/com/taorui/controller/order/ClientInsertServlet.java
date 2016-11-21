package com.taorui.controller.order;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import com.taorui.service.*;

import com.taorui.service.*;

@WebServlet("/HTML/home3/ClientInsertServlet")
public class ClientInsertServlet extends HttpServlet {
	StockServiceClient stock;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		stock = new StockServiceClient();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=gb2312");
		request.setCharacterEncoding("utf-8");
		String compName = request.getParameter("CompName").trim();
		String compCateg = request.getParameter("CompCateg");
		String loginID = request.getParameter("LoginID");
		String category = request.getParameter("Category");
		String regisTime1 = request.getParameter("RegisTime");

		String commoSourc = request.getParameter("CommoSourc").trim();
		String commoName = request.getParameter("CommoName").trim();
		String outTime1 = request.getParameter("OutTime").trim();
		String proArea = request.getParameter("ProArea").trim();// 时间
		String commoAdd = request.getParameter("CommoAdd").trim();

		String phone = request.getParameter("Phone").trim();
		String mobPhone = request.getParameter("MobPhone").trim();
		String email = request.getParameter("Email").trim();
		String fax = request.getParameter("Fax").trim();
		String clienBound = request.getParameter("ClienBound").trim();

		String zFB = request.getParameter("ZFB").trim();
		String chAtion = request.getParameter("ChAtion").trim();
		String taob = request.getParameter("taob").trim();
		String agencyFee = request.getParameter("AgencyFee").trim();
		String credMarg = request.getParameter("CredMarg").trim();

		String money1 = request.getParameter("Money").trim();
		String amount1 = request.getParameter("Amount").trim();
		String custName = request.getParameter("CustName").trim();
		String quantity1 = request.getParameter("Quantity").trim();
		String commodity1 = request.getParameter("Commodity").trim();

		int quantity = quantity1 == null || quantity1.equals("") ? 0 : Integer.parseInt(quantity1);
		int commodity = commodity1 == null || commodity1.equals("") ? 0 : Integer.parseInt(commodity1);
		double money = money1 == null || money1.equals("") ? 0 : Double.parseDouble(money1);
		double amount = amount1 == null || amount1.equals("") ? 0 : Double.parseDouble(amount1);
		Date regisTime = null, outTime = null;

		if (regisTime1.length() > 0) {
			SimpleDateFormat data = new SimpleDateFormat("yyyy-MM-dd");
			try {
				regisTime = data.parse(regisTime1);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		if (outTime1.length() > 0) {
			SimpleDateFormat data = new SimpleDateFormat("yyyy-MM-dd");
			try {
				outTime = data.parse(outTime1);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		int a = stock.insertClient(compName, credMarg, loginID, category, regisTime, commoSourc, commoName, outTime,
				commoAdd, phone, mobPhone, email, fax, clienBound, zFB, chAtion, taob, agencyFee, money, amount,
				compCateg, custName, quantity, commodity, proArea);
		PrintWriter out = response.getWriter();
		out.write("" + a);
		out.flush();
		out.close();
	}

}
