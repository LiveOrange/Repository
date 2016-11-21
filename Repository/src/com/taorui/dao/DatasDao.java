package com.taorui.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.taorui.entities.Dept;
import com.taorui.entities.Record;

public class DatasDao extends BaseDAO {

	public DatasDao() {
		super("jdbc/test");
	}

	private class RecordMapper implements RowMapper<Record> {
		@Override
		public Record rowMap(ResultSet rs) throws SQLException {
			Record contach = new Record();
			contach.setId(rs.getInt("id"));
			contach.setData(rs.getString("data"));
			contach.setRecord(rs.getString("record"));
			return contach;
		}
	}

	private class DataMapper implements RowMapper<Record> {
		@Override
		public Record rowMap(ResultSet rs) throws SQLException {
			Record contach = new Record();
			contach.setId(rs.getInt("id"));
			contach.setData(rs.getString("Hyphen"));
			return contach;
		}
	}
	// 出库查询2

	public List<Record> seleWareh() {
		String sql = "select * from tb_data  where id=1";
		try {
			return this.query(sql, new RecordMapper());
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}
	}

	public List<Record> contact() {
		String sql = "select * from tb_hphen order by id asc";
		try {
			return this.query(sql, new DataMapper());
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}
	}

	public boolean updateData(String data) {
		String sql = "update tb_data set record=? where id=1";
		try {
			return this.update(sql, data);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}
	}
}
