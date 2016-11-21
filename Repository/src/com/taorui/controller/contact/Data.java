package com.taorui.controller.contact;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.taorui.service.DatasService;
import com.taorui.tags.Chuankou;

/**
 * Servlet implementation class Data
 */
@WebServlet("/HTML/home3/Data")
public class Data extends HttpServlet {
	private DatasService dataService;

	@Override
	public void init() throws ServletException {
		super.init();
		dataService = new DatasService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=gb2312");
		request.setCharacterEncoding("utf-8");
		String data = request.getParameter("data");
		String datas=null;
		if ("1".equals(data) || "2".equals(data)) {
			datas = "010300140002840f";
		} else if ("3".equals(data)) {
			datas = "010300340001c5c4";
		} else if ("4".equals(data)) {
			datas = "0103003C00014406";
		}
		dataService.updateData(datas);
		// System.out.println(data);
	}

}
