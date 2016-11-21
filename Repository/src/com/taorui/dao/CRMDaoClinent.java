package com.taorui.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.taorui.entities.*;

public class CRMDaoClinent extends BaseDAO {
	public CRMDaoClinent() {
		super("jdbc/test");
	}

	private class Client1RowMapper implements RowMapper<Client1> {
		@Override
		public Client1 rowMap(ResultSet rs) throws SQLException {
			Client1 client = new Client1();
			client.setClientId(rs.getInt("Client_Id"));
			client.setClientName(rs.getString("Client_Name"));
			return client;
		}
	}

	private class Client3RowMapper implements RowMapper<Client3> {
		@Override
		public Client3 rowMap(ResultSet rs) throws SQLException {
			Client3 client = new Client3();
			client.setClientIndusttry(rs.getString("Client_Indention"));
			client.setLoginID(rs.getString("Client_LoginID"));
			client.setClientProd(rs.getString("Client_Prod"));
			client.setClientTime(new java.util.Date(rs.getDate("Client_Time").getTime()));
			client.setClientSource(rs.getString("Client_Source"));
			client.setClientWebsite(rs.getString("Client_Website"));
			client.setClientWebType(rs.getString("Client_WebType"));
			client.setClientRegion(rs.getString("Client_Region"));
			client.setClientAddress(rs.getString("Client_Address"));
			client.setClientNumber(rs.getInt("Client_Number"));
			client.setClientCorporat(rs.getString("Client_Corporat"));
			client.setClientPhone(rs.getString("Client_Phone"));
			client.setClientCall(rs.getString("Client_Call"));
			client.setEmail(rs.getString("E_Mail"));
			client.setClientFax(rs.getString("Client_Fax"));
			client.setClientBackground(rs.getString("Client_Background"));
			client.setZfb(rs.getString("Client_Alipay"));
			client.setTaobao(rs.getString("Client_taobao"));
			client.setEnsure(rs.getString("Client_ensure"));
			client.setClientOffer(rs.getInt("Client_Offer"));
			client.setClientReputat(rs.getDouble("Client_Reputat"));
			client.setClientPayment(rs.getDouble("Client_Payment"));
			client.setClientCapital(rs.getDouble("Client_Capital"));
			client.setClientName(rs.getString("Client_Name"));
			client.setClientfirm(rs.getString("Client_firm"));
			client.setClientOrder(rs.getString("Client_Order"));
			client.setClientId(rs.getInt("Client_Id"));
			client.setUserName(rs.getString("User_Name"));
			client.setUserId(rs.getInt("User_Id"));
			return client;
		}
	}

	// 1、账户撞单查询
	public List<Client1> clientQuery(Client1 client) {
		String sql = "select * from tb_client where Client_Name=?";
		try {
			return this.query(sql, new Client1RowMapper(), client.getClientName());
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}
	}

	// 2、账单添加
	public boolean insertClient(Client2 client) {
		String sql = "insert ignore into tb_client (" + "Client_Indention,Client_LoginID," + "Client_Prod,Client_Time,"
				+ "Client_Source,Client_Website," + "Client_WebType,Client_Region," + "Client_Address,Client_Number,"
				+ "Client_Corporat,Client_Phone," + "Client_Call,E_Mail," + "Client_Fax,Client_Background,"
				+ "Client_Alipay,Client_taobao," + "Client_ensure,Client_Offer," + "Client_Reputat,Client_Payment,"
				+ "Client_Capital,User_Id," + "User_Name,Client_Post," + "Client_Dept,Client_firm,"
				+ "Client_Name,Client_Order,Client_StorageTime) values " + "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,"
				+ "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,now())";
		try {
			return this.update(sql, client.getClientIndusttry(), client.getLoginID(), client.getClientProd(),
					client.getClientTime(), client.getClientSource(), client.getClientWebsite(),
					client.getClientWebType(), client.getClientRegion(), client.getClientAddress(),
					client.getClientNumber(), client.getClientCorporat(), client.getClientPhone(),
					client.getClientCall(), client.getEmail(), client.getClientFax(), client.getClientBackground(),
					client.getZfb(), client.getTaobao(), client.getEnsure(), client.getClientOffer(),
					client.getClientReputat(), client.getClientPayment(), client.getClientCapital(), client.getUserId(),
					client.getUserName(), client.getClientPost(), client.getClientDept(), client.getClientfirm(),
					client.getClientName(), client.getClientOrder());
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}
	}

	// 3、客户查询
	public List<Client3> findAllClient(String id) {
		String sql = "select * from tb_client  where" + " Client_Id  like ? " + " or  Client_Name like ?"
				+ " or Client_firm like ?" + " or Client_Industtry like ?" + " or Client_LoginID like ?";
		try {
			return this.query(sql, new Client3RowMapper(), id, id, id, id, id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}
	}

	// 4、客户查询
	public List<Client3> findAllClient(int id) {
		String sql = "select * from tb_client  where User_Id=?";
		try {
			return this.query(sql, new Client3RowMapper(), id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}
	}

	// 4、客户查询
	public List<Client3> findAllClient(Client3 client) {
		String sql = "select * from tb_client  " + " where User_Id=?  and  " + " Client_Name like ?"
				+ " or Client_LoginID like  ?";
		try {
			return this.query(sql, new Client3RowMapper(), client.getUserId(), client.getClientName(),
					client.getLoginID());
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}
	}

	// 5、总个数
	public int count(int id) {
		String sql = "select count(*) a from tb_client WHERE User_Id=?";
		try {
			return this.queryOne(sql, new RowMapper<Integer>() {
				@Override
				public Integer rowMap(ResultSet rs) throws SQLException {
					return rs.getInt("a");
				}
			}, id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}
	}

	// 6、分页查询
	public int count(int id, String data) {
		String sql = "select count(*) a from tb_client WHERE User_Id=? and Client_Order=?";
		try {
			return this.queryOne(sql, new RowMapper<Integer>() {
				@Override
				public Integer rowMap(ResultSet rs) throws SQLException {
					return rs.getInt("a");
				}
			}, id, data);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}
	}

	// 7、分页查询
	public List<Client3> getClient(int curpage, int pagesize, int id) {
		String sql = "select * from tb_client WHERE User_Id=?  limit ?,?";
		try {
			return this.query(sql, new Client3RowMapper(), id, (curpage - 1) * pagesize, pagesize);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}
	}

	// 8、分页查询
	public List<Client3> getClient(int curpage, int pagesize, int id, String data) {
		String sql = "select * from tb_client WHERE User_Id=? and Client_Order=?  limit ?,?";
		try {
			return this.query(sql, new Client3RowMapper(), id, data, (curpage - 1) * pagesize, pagesize);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}
	}


}
