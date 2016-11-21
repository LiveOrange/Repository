package com.taorui.controller.dep;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.taorui.service.CRMServiceXmw;

/**
 * Servlet implementation class DeptDelServlet
 */
@WebServlet("/HTML/home2/DeptDelServlet")
public class DeptDelServlet extends HttpServlet {
	CRMServiceXmw crmxmw;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		crmxmw = new CRMServiceXmw();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String dptName = request.getParameter("name").trim();
		int id = Integer.parseInt(request.getParameter("id"));
		String info = crmxmw.deptDel(dptName, id);
		request.setAttribute("info", info);
		request.getRequestDispatcher("../../info.jsp").forward(request, response);

	}

}
