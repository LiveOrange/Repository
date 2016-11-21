package com.taorui.controller.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class test
 */
@WebServlet("/HTML/xmw/test")
public class test extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		System.out.println("start............");
		String username = request.getParameter("username");
		String content = request.getParameter("content");
		PrintWriter out = response.getWriter();
		//	request.setAttribute("info", "132");
		//request.getRequestDispatcher("zx.jsp").forward(request, response);
		out.write(username);
		System.out.println("username>>==" + username);
		out.write("可以！");
		out.flush();
		out.close();
		System.out.println("end");
	}

}
