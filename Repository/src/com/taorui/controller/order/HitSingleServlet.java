package com.taorui.controller.order;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import com.taorui.service.*;

@WebServlet("/HTML/xmw/HitSingleServlet")
public class HitSingleServlet extends HttpServlet {
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
		String username = request.getParameter("clientName").trim();
		PrintWriter out = response.getWriter();
		int a;
		if (username.length() != 0) {
			a = crmxmw.HitSingle(username);
		} else {
			a = 0;
		}
		out.write("" + a);
		out.flush();
		out.close();
	}
}
