package com.taorui.controller.contact;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.taorui.entities.PageInfo2;
import com.taorui.entities.UserCount;
import com.taorui.entities.UserCount2;
import com.taorui.service.CRMServiceClient;

@WebServlet("/HTML/xmw/ContactsServlet")
public class ContactsServlet extends HttpServlet {
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
		PageInfo2<UserCount2> list = crmxmw.count(id);
		request.setAttribute("info", list);
		request.getRequestDispatcher("indexcount.jsp").forward(request, response);
	}

}
