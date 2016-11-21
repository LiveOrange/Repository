package com.taorui.controller.contact;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import com.taorui.service.CRMServiceClients;

@WebServlet("/HTML/dzx/ConsumerServlet")
public class ConsumerServlet extends HttpServlet {
	CRMServiceClients crm;
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		crm=new CRMServiceClients();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=gb2312");
		request.setCharacterEncoding("utf-8");
	
		String ordId1 = request.getParameter("td1");
		String coutOrd = request.getParameter("td2");
		String  id= request.getParameter("x");
		String name=request.getParameter("x1");
		System.out.println(ordId1+":"+coutOrd+":"+id+":"+name);
		crm.updataConsum(Integer.parseInt(id));
		crm.deletConsum(Integer.parseInt(coutOrd));
		crm.updataClient(Integer.parseInt(id), name,Integer.parseInt(ordId1));
	}

}
