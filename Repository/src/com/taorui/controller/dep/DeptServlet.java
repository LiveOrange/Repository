package com.taorui.controller.dep;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import com.taorui.service.CRMServiceXmw;

/**
 * 部门添加
 */
@WebServlet("/HTML/home2/DeptServlet")
public class DeptServlet extends HttpServlet {
	CRMServiceXmw crmxmw;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		crmxmw = new CRMServiceXmw();
	}

	// 部门添加
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=gb2312");
		request.setCharacterEncoding("utf-8");
		String dptName = request.getParameter("name");
		String info = crmxmw.insertDept(dptName);
		request.setAttribute("info", info+dptName);
		request.getRequestDispatcher("../../info.jsp").forward(request, response);
	}
	
}
