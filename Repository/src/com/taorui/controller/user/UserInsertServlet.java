package com.taorui.controller.user;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import com.taorui.service.CRMServiceXmw;

@WebServlet("/HTML/home2/UserInsertServlet")
public class UserInsertServlet extends HttpServlet {
	CRMServiceXmw crmxmw;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		crmxmw = new CRMServiceXmw();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=gb2312");
		request.setCharacterEncoding("utf-8");
		String userName = request.getParameter("name");
		String password = request.getParameter("password");
		int job = Integer.parseInt(request.getParameter("job"));
		int deptid = Integer.parseInt(request.getParameter("depa"));
		String idcard = request.getParameter("idCard");
		String address = request.getParameter("address");
		String info =crmxmw.insertUser(userName, password, job, idcard, deptid, address);
		System.out.println(userName + ":" + password + ":" + job + ":" + deptid + ":" + address + ":" + idcard);
		request.setAttribute("info", info);
		request.getRequestDispatcher("../../info.jsp").forward(request, response);
}

}
