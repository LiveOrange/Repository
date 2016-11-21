package com.taorui.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.management.Query;
import javax.naming.*;
import javax.sql.*;

public class BaseDAO {
	private static Context cont;
	private String dataSource;

	/**
	 * 基础DAO，封装通用的执行SQL语句的方法
	 */
	public BaseDAO(String dataSource) {
		this.dataSource = dataSource;
	}

	/**
	 * 获取连接对象
	 */
	public Connection getConnection() {
		try {
			if (cont == null) {
				cont = new InitialContext();
			}
			DataSource ds = (DataSource) cont.lookup("java:/comp/env/" + this.dataSource);
			Connection conn = ds.getConnection();
			return conn;
		} catch (NamingException e) {
			e.printStackTrace();
			throw new DBException(e);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException(e);
		}
	}

	/**
	 * 释放资源
	 */
	public void close(Connection conn, Statement stmt, ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new DBException(e);
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
					throw new DBException(e);
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					throw new DBException(e);
				}
			}
		}
	}

	/**
	 * 执行insert,update,delete语句
	 */
	public boolean update(String sql, Object... params) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = getConnection();
			stmt = conn.prepareStatement(sql);
			bindParameters(stmt, params);
			stmt.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException(e);
		} finally {
			close(conn, stmt, null);
		}

	}

	/**
	 * 绑定参数
	 */
	private void bindParameters(PreparedStatement stmt, Object... params) throws SQLException {
		if (params != null) {
			for (int i = 0; i < params.length; i++) {
				stmt.setObject(i + 1, params[i]);
			}
		}
	}

	/**
	 * 查询
	 */
	public <T> List<T> query(String sql, RowMapper<T> rowMapper, Object... params) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		conn = getConnection();
		try {
			stmt = conn.prepareStatement(sql);
			bindParameters(stmt, params);
			rs = stmt.executeQuery();
			// 读取记录
			List<T> list = new ArrayList<>();
			while (rs.next()) {
				T t = rowMapper.rowMap(rs);
				list.add(t);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException(e);
		} finally {
			close(conn, stmt, rs);
		}
	}
	/**
	 * 查找，返回一个值
	 */
	public <T> T queryOne(String sql, RowMapper<T> rowMapper, Object... params) {
		List<T> list = this.query(sql, rowMapper, params);
		return list != null && list.size() > 0 ? list.get(0) : null;
	}
}
