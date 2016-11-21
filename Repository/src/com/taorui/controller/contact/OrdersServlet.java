package com.taorui.controller.contact;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.taorui.service.StockServiceClient;

/**
 * Servlet implementation class OrdersServlet
 */
@WebServlet("/HTML/home3/OrdersServlet")
public class OrdersServlet extends HttpServlet {
	private StockServiceClient stock;

	@Override
	public void init() throws ServletException {
		super.init();
		stock = new StockServiceClient();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		int a = stock.updatWarehs(id);
		PrintWriter out = response.getWriter();
		out.write(a + "");
	}
}
