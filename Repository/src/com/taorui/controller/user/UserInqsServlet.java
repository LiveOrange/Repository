package com.taorui.controller.user;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.taorui.entities.Dept;
import com.taorui.entities.PageInfo;
import com.taorui.entities.User1;
import com.taorui.service.CRMServiceXmw;

/**
 * Servlet implementation class UserInqsServlet
 */
@WebServlet("/HTML/home2/UserInqsServlet")
public class UserInqsServlet extends HttpServlet {
	CRMServiceXmw crmxmw;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		crmxmw = new CRMServiceXmw();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int curpage = Integer.parseInt(request.getParameter("curpage"));
		int pagesize = Integer.parseInt(request.getParameter("pagesize"));
		System.out.println(curpage+""+pagesize);
		PageInfo<User1> list = crmxmw.getUser(curpage, pagesize);
		request.setAttribute("info", list);
		request.getRequestDispatcher("user.jsp").forward(request, response);

	}

}
