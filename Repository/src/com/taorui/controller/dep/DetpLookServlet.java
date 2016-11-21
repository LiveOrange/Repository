package com.taorui.controller.dep;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import javax.websocket.Session;

import com.taorui.entities.Dept;
import com.taorui.service.CRMServiceXmw;

/**
 * Servlet implementation class DetpLookServlet
 */
@WebServlet("/HTML/home2/DetpLookServlet")
public class DetpLookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CRMServiceXmw crmxmw;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		crmxmw = new CRMServiceXmw();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Dept> list = crmxmw.findAllDept();
		request.setAttribute("info", list);
		request.getRequestDispatcher("staff.jsp").forward(request, response);

	}

}
