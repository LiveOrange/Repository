package com.taorui.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.mysql.fabric.xmlrpc.base.Data;
import com.taorui.entities.*;

/**
 * 账单联系人
 */
public class CRMDaoContach extends BaseDAO {

	public CRMDaoContach() {
		super("jdbc/test");
	}

	private class ContachRowMapper implements RowMapper<Contach> {
		@Override
		public Contach rowMap(ResultSet rs) throws SQLException {
			Contach contach = new Contach();
			contach.setClientId(rs.getInt("Client_Id"));
			contach.setClientName(rs.getString("Client_Name"));
			contach.setId(rs.getInt("User_Id"));
			contach.setContext(rs.getString("Contach_Context"));
			contach.setChWay(rs.getString("Contach_Way"));
			contach.setMaturity(rs.getString("Maturity"));
			contach.setAttribute(rs.getString("Client_Attribute"));
			contach.setEmail(rs.getString("E_Mail"));
			contach.setClientIm(rs.getString("Client_Im"));
			contach.setClientCall(rs.getString("Client_Call"));
			contach.setClientPhone(rs.getString("Client_Phone"));
			contach.setClientFax(rs.getString("Client_Fax"));
			contach.setTime(new java.util.Date(rs.getDate("Contach_Time").getTime()));
			contach.setClientName(rs.getString("Client_Name"));
			contach.setClientProd(rs.getString("Client_Prod"));
			return contach;
		}
	}

	// 1、联系人查询
	public List<Contach> contachQuery(int userid) {
		String sql = "select * from tb_contach where User_Id=?";
		try {
			return this.query(sql, new ContachRowMapper(), userid);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}
	}

	// 2、联系人查询
	public List<Contach> contachQuery(Contach contach) {
		String sql = "select * from tb_contach where User_Id=? and Client_Name=?";
		try {
			return this.query(sql, new ContachRowMapper(), contach.getId(), contach.getClientName());
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}
	}

	// 2、账单添加
	public boolean insertContach(Contach contach) {
		String sql = "insert ignore into tb_contach ("
				+ " User_Id,Contach_Context,"
				+ " Contach_Way,Client_Attribute,"
				+ " Client_Name,Client_Im,"
				+ " Client_Call,Client_Phone,"
				+ " Client_Fax,E_Mail, Maturity,"
				+ " Client_Prod,Contach_Time) "
				+ " values (?,?,?,?,?,?,?,?,?,?,?,?,now())";
		try {
			return this.update(sql,
					contach.getId(),
					contach.getContext(), 
					contach.getChWay(),
					contach.getAttribute(),
					contach.getClientName(),
					contach.getClientIm(), 
					contach.getClientCall(), 
					contach.getClientPhone(),
					contach.getClientFax(),
					contach.getEmail(), 
					contach.getMaturity(),
					contach.getClientProd());
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}
	}

	// 4、修改
	public boolean updateContach(Contach client) {
		String sql = "update  tb_contach set " + "Contach_Context=?," + "Contach_Way=?," + "Client_Attribute=? ,"
				+ "E_Mail=?," + "Client_Im=?," + "Client_Call=?," + "Client_Phone=?," + "Client_Fax=?,"
				+ "Client_Name=?," + "Contach_Time=now()" + "where Client_Id=?";
		try {
			return this.update(sql, client.getContext(), client.getChWay(), client.getAttribute(), client.getEmail(),
					client.getClientIm(), client.getClientCall(), client.getClientPhone(), client.getClientFax(),
					client.getClientName(), client.getId());
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}
	}

	// 2、联系人查询
	public boolean contachDel(int id) {
		String sql = "delete from tb_contach where Client_Id=?;";
		try {
			return this.update(sql, id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}
	}
}
