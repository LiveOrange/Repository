package com.taorui.controller.thread;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.taorui.service.ThreadUser;

/**
 * Servlet implementation class UserThead
 */
@WebServlet("/HTML/dzx/UserThead")
public class UserThead extends HttpServlet {
	ThreadUser crm;
	
	public UserThead() {
		crm = new ThreadUser();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Thread thred = new Thread(crm);
		 thred.start();
	}

}
