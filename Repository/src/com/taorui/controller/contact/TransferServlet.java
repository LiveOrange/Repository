package com.taorui.controller.contact;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.taorui.entities.OrdersSum;
import com.taorui.service.StockServiceClient;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class TransferServlet
 */
@WebServlet("/HTML/home/TransferServlet")
public class TransferServlet extends HttpServlet {
	private StockServiceClient stock;

	@Override
	public void init() throws ServletException {
		super.init();
		stock = new StockServiceClient();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=gb2312");
		request.setCharacterEncoding("utf-8");
		String data = request.getParameter("data");
		String id1 = request.getParameter("id");
		String id = id1.substring(0, id1.length() - 1);
		int j=0;
		String[] aa = id.split("\\+");
		for (int i = 0; i < aa.length; i++) {
			j=stock.updatWare(data, Integer.parseInt(aa[i]));
		}

		PrintWriter out = response.getWriter();
		out.print(j+"");
	}

}
