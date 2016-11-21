package com.taorui.dao;

public class TbStudentDao {
	/**
	 * 领域层：系统内的领域活动
	 */
	private BaseDao1 db;

	public TbStudentDao() {
		db = new BaseDao1();
	}

	public int changeDemos(int id, String hep) throws Exception {
		String sql = "update tb_hphen set Hyphen=? where id=?;";
		int b;
		b = db.executeUpdate(sql, hep, id);
		return b;
	}
}
