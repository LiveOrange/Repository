package com.taorui.controller.dep;

import java.io.IOException;
import java.util.List;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import com.taorui.entities.Dept;
import com.taorui.entities.PageInfo;
import com.taorui.service.*;

/**
 * 部门查询
 */
@WebServlet("/HTML/home2/DeptInqServlet")
public class DeptInqServlet extends HttpServlet {

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
		PageInfo<Dept> list = crmxmw.getDept(curpage, pagesize);
		request.setAttribute("info", list);
		request.getRequestDispatcher("deptlist.jsp").forward(request, response);
	}

}
