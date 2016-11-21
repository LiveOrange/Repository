package com.taorui.controller.order;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.taorui.entities.Contach;
import com.taorui.service.CRMServiceClient;

import net.sf.json.JSONArray;

@WebServlet("/HTML/xmw/ContachupdatServlet")
public class ContachupdatServlet extends HttpServlet {
	CRMServiceClient crmxmw;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		crmxmw = new CRMServiceClient();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=gb2312");
		request.setCharacterEncoding("utf-8");
		int id = Integer.parseInt(request.getParameter("id"));
		List<Contach> list = crmxmw.findAllContach(id);
		SimpleDateFormat datas = new java.text.SimpleDateFormat("yyyy-MM-dd");
		for (int i = 0; i < list.size(); i++) {
			String aa = datas.format(list.get(i).getTime()) + "";
			list.get(i).setData(aa);
		}
		PrintWriter out = response.getWriter();
		JSONArray array = JSONArray.fromObject(list.toArray());
		out.write(array.toString());
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=gb2312");
		request.setCharacterEncoding("utf-8");
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		List<Contach> list = crmxmw.findAllContach(id, name);
		SimpleDateFormat datas = new java.text.SimpleDateFormat("yyyy-MM-dd");
		System.out.println(list.size());
		for (int i = 0; i < list.size(); i++) {
			String aa = datas.format(list.get(i).getTime()) + "";
			list.get(i).setData(aa);
		}
		PrintWriter out = response.getWriter();
		JSONArray array = JSONArray.fromObject(list.toArray());
		out.write(array.toString());
	}

}
