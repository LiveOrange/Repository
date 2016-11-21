package com.taorui.controller.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.taorui.entities.Dept;
import com.taorui.entities.User1;
import com.taorui.service.CRMServiceXmw;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class UserupdtServlet
 */
@WebServlet("/HTML/home2/UserupdtServlet")
public class UserupdtServlet extends HttpServlet {
	CRMServiceXmw crmxmw;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		crmxmw = new CRMServiceXmw();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String userName = request.getParameter("name");
		String deptName = request.getParameter("dept");
		int job = Integer.parseInt(request.getParameter("job"));
		int empState = Integer.parseInt(request.getParameter("empState"));
		String info = crmxmw.updateUser(id, userName, deptName, job, empState);
		request.setAttribute("info", info);
		request.getRequestDispatcher("../../info.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=gb2312");
		request.setCharacterEncoding("utf-8");
		List<User1> list = crmxmw.finClientByPage();
		PrintWriter out = response.getWriter();
		JSONArray array = JSONArray.fromObject(list.toArray());
		out.write(array.toString());
	}
}
