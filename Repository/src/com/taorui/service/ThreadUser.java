package com.taorui.service;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import com.taorui.dao.*;
import com.taorui.entities.*;
import com.taorui.tags.Chuankou;

public class ThreadUser implements Runnable {

	private CRMDaoClient crmdao;
	private DatasService datasService;
	private Chuankou chuankou ;
	public ThreadUser() {
		crmdao = new CRMDaoClient();
		datasService = new DatasService();
		chuankou = new Chuankou();
		chuankou.Maininterface();
	}

	@Override
	public void run() {
		int a = 0;
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		while (true) {
			String aString = datasService.datas();
			try {
				chuankou.sendout(aString);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
