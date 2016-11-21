package com.taorui.service;

import com.taorui.dao.TbStudentDao;

public class HphenService {
	TbStudentDao dao;

	public HphenService() {
		dao = new TbStudentDao();
	}

	public void Hphen(String rec, String data) {
		try {
			if ("010300140002840f".equals(rec)) {
				dao.changeDemos(1, data);

			} else {
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
