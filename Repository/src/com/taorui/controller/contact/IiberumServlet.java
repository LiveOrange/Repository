package com.taorui.controller.contact;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.taorui.entities.Comsea;
import com.taorui.entities.PageInfo;
import com.taorui.service.CRMServiceContact;

/**
 * Servlet implementation class IiberumServlet
 */
@WebServlet("/HTML/dzx/IiberumServlet")
public class IiberumServlet extends HttpServlet {
	CRMServiceContact crmxmw;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		crmxmw = new CRMServiceContact();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String curpage = request.getParameter("curpage");
		String pagesize = request.getParameter("pagesize");
		String logid = request.getParameter("logid");
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String username = request.getParameter("username");
		String prod = request.getParameter("prod");
		String a1=request.getParameter("a");
		String x=request.getParameter("x");
		int x1=Integer.parseInt(x);
		int a=a1==null?0:Integer.parseInt(a1) ;
		int cp = curpage == null ? 1 : Integer.parseInt(curpage);
		int pz = pagesize == null ? 1 : Integer.parseInt(pagesize);
		PageInfo<Comsea> list=null;
		if(a==1){
			list=crmxmw.getUser(cp, pz, logid, id, name, prod, a,x1,username);
		
		}else {
			 list= crmxmw.getUser(cp, pz,a,x1,username);	
		}
		request.setAttribute("info", list);
		request.getRequestDispatcher("user.jsp").forward(request, response);
	}

}
