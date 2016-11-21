package com.taorui.controller.order;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.taorui.entities.User1;
import com.taorui.service.CRMServiceXmw;


@WebServlet("/HTML/xmw/ClientInqsServlet")
public class ClientInqsServlet extends HttpServlet {

	CRMServiceXmw crmxmw;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		crmxmw = new CRMServiceXmw();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<User1> list = crmxmw.finClientByPage();
		response.setContentType("text/html;charset=gb2312");
		request.setCharacterEncoding("utf-8");
		String username = request.getParameter("clientName").trim();
		int i = -1;
		for (User1 data : list) {
			if (data.getUserName().equals(username)) {
				i = data.getId();
				System.out.println("满足！");
				break;
			}
		}
		PrintWriter out = response.getWriter();
		System.out.println(i);
		out.write("" + i);
		out.flush();
		out.close();
	}

}
