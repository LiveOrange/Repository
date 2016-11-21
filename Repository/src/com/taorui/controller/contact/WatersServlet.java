package com.taorui.controller.contact;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.taorui.entities.*;
import com.taorui.service.*;

import net.sf.json.JSONArray;

@WebServlet("/HTML/xmw/WatersServlet")
public class WatersServlet extends HttpServlet {
	CRMServiceContact crmxmw;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		crmxmw = new CRMServiceContact();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		List<User1> liset = crmxmw.usersQuery(id);
		PrintWriter out = response.getWriter();
		JSONArray array = JSONArray.fromObject(liset);
		out.write(array.toString());

	}

}
