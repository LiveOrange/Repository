package com.taorui.controller.contact;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import com.taorui.entities.Client3;
import com.taorui.entities.Client5;
import com.taorui.service.*;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class MyClientServlet
 */
@WebServlet("/HTML/home/MyClientServlet")
public class MyClientServlet extends HttpServlet {
	StockServiceClient crmxmw;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		crmxmw = new StockServiceClient();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=gb2312");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String loginID = request.getParameter("LoginID");
		String compName = request.getParameter("CompName");
		String commoName = request.getParameter("CommoName");
		String custName = request.getParameter("CustName");
		String commoSourc = request.getParameter("CommoSourc");
		String RegisTime = request.getParameter("RegisTime");
		Date regisTime = null;
		if (RegisTime.length() > 0) {
			SimpleDateFormat data = new SimpleDateFormat("yyyy-MM-dd");
			try {
				regisTime = data.parse(RegisTime);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}

		List<Client5> list = crmxmw.seleClient(compName, loginID, regisTime, commoSourc, commoName, custName);
		System.out.println(list.size());
		int b = 0, c = 0;
		for (Client5 client : list) {
			int a = 0;
			if (loginID != null && !loginID.equals("") && loginID.equals(client.getLoginID()))
				a++;
			if (compName != null && !compName.equals("") && compName.equals(client.getCompName()))
				a++;
			if (commoName != null && !commoName.equals("") && commoName.equals(client.getCommoName()))
				a++;
			if (custName != null && !custName.equals("") && custName.equals(client.getCustName()))
				a++;
			if (commoSourc != null && !commoSourc.equals("") && commoSourc.equals(client.getCommoSourc()))
				a++;
			if (regisTime != null && !regisTime.equals("") && client.getOutTime() == regisTime)
				a++;
			b = a > c ? client.getId() : b;
			client.setSum(b);
			System.out.println(client.getId() + "\t" + b);
		}
		if (b == 0) {
			out.write(""+0);
		} else {
			list.get(0).setSum(b);
			JSONArray array = JSONArray.fromObject(list.toArray());
			out.write(array.toString());
		}

	}

}
