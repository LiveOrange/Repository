package com.taorui.controller.order;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

import com.taorui.entities.Contach;
import com.taorui.service.CRMServiceClient;
import com.taorui.service.CRMServiceClients;
import com.taorui.service.StockServiceClient;

import net.sf.json.JSONArray;

@WebServlet("/HTML/home/ContachInsertServlet")
public class ContachInsertServlet extends HttpServlet {

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
		String id1 = request.getParameter("id");
		String wareh = request.getParameter("wareh");
		String agency = request.getParameter("agency");
		String OutTime = request.getParameter("OutTime");
		String userName = request.getParameter("userName");
		Date regisTime = null;
		int id = Integer.parseInt(id1);
		if (OutTime.length() > 0) {
			SimpleDateFormat data = new SimpleDateFormat("yyyy-MM-dd");
			try {
				regisTime = data.parse(OutTime);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		int a = crmxmw.insertWareh(agency, wareh, userName, regisTime, id);
		PrintWriter out = response.getWriter();
		out.write("" + a);

	}

}
