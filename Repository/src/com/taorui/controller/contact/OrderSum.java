package com.taorui.controller.contact;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.taorui.entities.OrdersSum;
import com.taorui.entities.User1;
import com.taorui.service.StockServiceClient;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class OrdersSum
 */
@WebServlet("/HTML/home3/OrderSum")
public class OrderSum extends HttpServlet {
	private StockServiceClient stock;

	@Override
	public void init() throws ServletException {
		super.init();
		stock = new StockServiceClient();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		OrdersSum order = stock.countWareh();
		JSONObject jObj = new JSONObject();
		jObj.put("Sum", order.getSum());
		jObj.put("Sum1", order.getSum1());
		jObj.put("Sum2", order.getSum2());
		jObj.put("Sum3", order.getSum3());
		jObj.put("Sum4", order.getSum4());
		jObj.put("Sum5", order.getSum5());
		jObj.put("Sum6", order.getSum6());
		PrintWriter out = response.getWriter();
		out.print(jObj);
	}

}
