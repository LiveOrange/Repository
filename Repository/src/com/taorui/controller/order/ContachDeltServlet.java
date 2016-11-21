package com.taorui.controller.order;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.taorui.service.CRMServiceClient;

/**
 * Servlet implementation class ContachDeltServlet
 */
@WebServlet("/HTML/xmw/ContachDeltServlet")
public class ContachDeltServlet extends HttpServlet {
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
		String aa = crmxmw.contachDel(id);
		PrintWriter out = response.getWriter();
		out.write("" + aa);

	}

}
