package com.taorui.controller.order;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.fabric.xmlrpc.base.Data;
import com.taorui.entities.Client2;
import com.taorui.entities.Client3;
import com.taorui.entities.PageInfo;
import com.taorui.entities.User1;
import com.taorui.entities.Wareh2;
import com.taorui.service.CRMServiceClient;
import net.sf.json.*;
import net.sf.json.JSONObject;

@WebServlet("/HTML/home3/CustomerInqServlet")
public class CustomerInqServlet extends HttpServlet {

	CRMServiceClient crmxmw;

	/**
	 * 订单详情
	 */

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		crmxmw = new CRMServiceClient();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=gb2312");
		request.setCharacterEncoding("utf-8");
		String clientName = request.getParameter("clientName");
		PrintWriter out = response.getWriter();
		String x = request.getParameter("id");
		if (x.equals("0")) {
		} else if (x.equals("1")) {
			List<Client3> list = crmxmw.findAllClient(clientName);
			if (list != null && list.size() > 0) {
				Date data = list.get(0).getClientTime();
				SimpleDateFormat aa = new java.text.SimpleDateFormat("yyyy-MM-dd");
				String datas = aa.format(data) + "";
				list.get(0).setDatas(datas);
				JSONArray array = JSONArray.fromObject(list.toArray());
				out.write(array.toString());
			}
		} else if (x.equals("2")) {
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=gb2312");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String curpage = request.getParameter("curpage");
		String pagesize = request.getParameter("pagesize");
		String data = request.getParameter("data");
		int cp = curpage == null ? 1 : Integer.parseInt(curpage);
		int pz = pagesize == null ? 5 : Integer.parseInt(pagesize);
		List<Wareh2> list = crmxmw.getfindAllClient(cp, pz, data);
		SimpleDateFormat datas = new java.text.SimpleDateFormat("yyyy-MM-dd");
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				String aa = datas.format(list.get(i).getRegisTime()) + "";
				list.get(i).setDatas(aa);
			}
			JSONArray array = JSONArray.fromObject(list.toArray());
			out.write(array.toString());
		} else {
			out.write("");
		}
	}

}
