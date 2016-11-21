package com.taorui.controller.user;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import com.taorui.entities.*;
import com.taorui.service.*;

@WebServlet("/HTML/home/UserEnctysServlet")
public class UserEnctysServlet extends HttpServlet {
	CRMServiceXmw crmxmw;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		crmxmw = new CRMServiceXmw();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=gb2312");
		request.setCharacterEncoding("utf-8");
		String userName = request.getParameter("name");
		String password = request.getParameter("emailaddress");
		System.out.println(userName + ":" + password);
		User user = crmxmw.user(userName, password);
		HttpSession session = request.getSession();
		if (user != null) {
			session.setAttribute("name", user.getUserName());
			session.setAttribute("job", user.getJob());
			session.setAttribute("id", user.getId());
			response.setHeader("refresh", "0;URL=../home3/home.jsp");
		} else {
			session.setAttribute("name", null);
			request.setAttribute("info", "登录失败！");
			request.getRequestDispatcher("../../info.jsp").forward(request, response);
		}
	}

}
