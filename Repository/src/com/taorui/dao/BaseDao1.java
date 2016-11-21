package com.taorui.dao;

import java.sql.*;

public class BaseDao1 {
	/**
	 * DAO层：数据访问对象，通过领域实体对象来操作数据库。
	 */
	private Connection connection = null;
	private PreparedStatement ps = null;

	// 1、打开
	public void createConnection() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/storage", "root", "123456");
	}

	// ２、关闭
	public void close(ResultSet rs) throws Exception {
		if (rs != null) {
			rs.close();
		}
		if (ps != null) {
			ps.close();
		}
		if (connection != null) {
			connection.close();
		}
	}

	// 3、查询
	public ResultSet executeQuery(String sql, Object... objects) throws Exception {
		this.createConnection();

		ps = connection.prepareStatement(sql);
		if (objects != null) {
			for (int i = 0; i < objects.length; i++) {
				ps.setObject(i + 1, objects[i]);
			}
		}
		ResultSet rs = ps.executeQuery();
		return rs;
	}

	// 4、添改删
	public int executeUpdate(String sql, Object... objects) throws Exception {
		this.createConnection();
		ps = connection.prepareStatement(sql);
		if (objects != null) {
			for (int i = 0; i < objects.length; i++) {
				ps.setObject(i + 1, objects[i]);
			}
		}
		int row = ps.executeUpdate();
		// 调用关闭close
		this.close(null);
		return row;
	}
}
