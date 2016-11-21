package com.taorui.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.taorui.entities.*;

public class StockDao extends BaseDAO {

	public StockDao() {
		super("jdbc/test");
	}

	private class ContachRowMapper implements RowMapper<Client5> {
		@Override
		public Client5 rowMap(ResultSet rs) throws SQLException {
			Client5 contach = new Client5();
			contach.setCompName(rs.getString("CompName"));
			contach.setCompCateg(rs.getString("CompCateg"));
			contach.setLoginID(rs.getString("LoginID"));
			contach.setCategory(rs.getString("Category"));
			contach.setRegisTime(new java.util.Date(rs.getDate("Datas").getTime()));
			contach.setCommoSourc(rs.getString("CommoSourc"));
			contach.setCommoName(rs.getString("CommoName"));
			contach.setProArea(rs.getString("ProArea"));
			contach.setCommoAdd(rs.getString("CommoAdd"));
			contach.setPhone(rs.getString("Phone"));
			contach.setAmount(rs.getDouble("Amount"));
			contach.setQuantity(rs.getInt("Quantity"));
			contach.setCustName(rs.getString("CustName"));
			contach.setAgencyFee(rs.getString("AgencyFee"));
			contach.setId(rs.getInt("ID"));
			return contach;
		}
	}

	private class WarehRowMapper implements RowMapper<Wareh2> {
		@Override
		public Wareh2 rowMap(ResultSet rs) throws SQLException {
			Wareh2 contach = new Wareh2();
			contach.setCompName(rs.getString("CompName"));
			contach.setCompCateg(rs.getString("CompCateg"));
			contach.setLoginID(rs.getString("LoginID"));
			contach.setCategory(rs.getString("Category"));
			contach.setRegisTime(new java.util.Date(rs.getDate("Datas").getTime()));
			contach.setCommoSourc(rs.getString("CommoSourc"));
			contach.setCommoName(rs.getString("CommoName"));
			contach.setProArea(rs.getString("ProArea"));
			contach.setCommoAdd(rs.getString("CommoAdd"));
			contach.setPhone(rs.getString("Phone"));
			contach.setAmount(rs.getDouble("Amount"));
			contach.setQuantity(rs.getInt("Quantity"));
			contach.setCustName(rs.getString("CustName"));
			contach.setAgencyFee(rs.getString("AgencyFee"));
			contach.setId(rs.getInt("ID"));
			contach.setAgency(rs.getString("Agency"));
			contach.setUserName(rs.getString("UserName"));
			contach.setWareh(rs.getString("Wareh"));
			return contach;
		}
	}

	// 1、账单添加
	public boolean insertClient(Client5 client) {
		String sql = "insert ignore into tb_stock(" + "CompName,CredMarg," + "LoginID,Category,"
				+ "RegisTime,CommoSourc," + "CommoName,OutTime," + "CommoAdd,Phone," + "MobPhone,Email,"
				+ "Fax,ClienBound," + "ZFB,ChAtion," + "taob,AgencyFee," + "Money,Amount," + "CompCateg,CustName,"
				+ "Quantity,State," + "Commodity,ProArea," + "Datas) values " + "(" + "?,?,?,?,?," + "?,?,?,?,?,"
				+ "?,?,?,?,?," + "?,?,?,?,?," + "?,?,?,?,?" + ",?,now())";
		try {
			return this.update(sql, client.getCompName(), client.getCredMarg(), client.getLoginID(),
					client.getCategory(), client.getRegisTime(), client.getCommoSourc(), client.getCommoName(),
					client.getOutTime(), client.getCommoAdd(), client.getPhone(), client.getMobPhone(),
					client.getEmail(), client.getFax(), client.getClienBound(), client.getZFB(), client.getChAtion(),
					client.getTaob(), client.getAgencyFee(), client.getMoney(), client.getAmount(),
					client.getCompCateg(), client.getCustName(), client.getQuantity(), client.getState(),
					client.getCommodity(), client.getProArea());

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}
	}

	// 1
	public int countWareh1() {
		String sql = "select count(*) a from tb_wareh WHERE State=1";
		try {
			return this.queryOne(sql, new RowMapper<Integer>() {
				@Override
				public Integer rowMap(ResultSet rs) throws SQLException {
					return rs.getInt("a");
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}
	}

	// 2
	public int countWareh2(String data) {
		String sql = "select count(*) a from tb_wareh WHERE State=1 AND Wareh=?";
		try {
			return this.queryOne(sql, new RowMapper<Integer>() {
				@Override
				public Integer rowMap(ResultSet rs) throws SQLException {
					return rs.getInt("a");
				}
			}, data);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}
	}

	// 出库查询1
	public List<Wareh2> seleWareh(int curpage, int pagesize) {
		String sql = "select * from tb_wareh  where State=1 limit ?,?";
		try {
			return this.query(sql, new WarehRowMapper(), (curpage - 1) * pagesize, pagesize);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}
	}

	// 出库查询2
	public List<Wareh2> seleWareh(int curpage, int pagesize, String data) {
		String sql = "select * from tb_wareh  where State=1 AND Wareh=? limit ?,?";
		try {
			return this.query(sql, new WarehRowMapper(), data, (curpage - 1) * pagesize, pagesize);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}
	}

	public List<Client5> seleClient(Client5 client) {
		String sql = "select * from tb_stock  where State=1 and " + "( LoginID like ?" + " or CompName like ?"
				+ " or CommoName like ?" + " or CustName like ?" + " or CommoSourc like ? " + " or Datas like ?)";
		try {
			return this.query(sql, new ContachRowMapper(), client.getLoginID(), client.getCompName(),
					client.getCommoName(), client.getCustName(), client.getCommoSourc(), client.getRegisTime());
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}
	}

	public boolean insertWareh(Wareh wareh) {
		String sql = "INSERT INTO tb_wareh(tb_wareh.ProArea,tb_wareh.CompName," + "tb_wareh.CredMarg,tb_wareh.LoginID, "
				+ "tb_wareh.Category,tb_wareh.CommoSourc," + "tb_wareh.CommoName,tb_wareh.CommoAdd,"
				+ " tb_wareh.Phone,tb_wareh.MobPhone," + "tb_wareh.Email,tb_wareh.Fax,"
				+ "tb_wareh.ClienBound,tb_wareh.ZFB," + "tb_wareh.ChAtion,tb_wareh.taob,"
				+ "tb_wareh.AgencyFee,tb_wareh.Money," + "tb_wareh.Amount,tb_wareh.CompCateg"
				+ ",tb_wareh.CustName,tb_wareh.Quantity," + "tb_wareh.Commodity,tb_wareh.State,"
				+ "tb_wareh.Datas,tb_wareh.UserName," + "tb_wareh.Agency,tb_wareh.Wareh," + "tb_wareh.OutTime)"
				+ "select " + "tb_stock.ProArea,tb_stock.CompName," + "tb_stock.CredMarg,tb_stock.LoginID,"
				+ "tb_stock.Category,tb_stock.CommoSourc," + "tb_stock.CommoName,tb_stock.CommoAdd,"
				+ "tb_stock.Phone,tb_stock.MobPhone," + "tb_stock.Email,tb_stock.Fax,"
				+ "tb_stock.ClienBound,tb_stock.ZFB," + "tb_stock.ChAtion,tb_stock.taob,"
				+ "tb_stock.AgencyFee,tb_stock.Money," + "tb_stock.Amount,tb_stock.CompCateg,"
				+ "tb_stock.CustName,tb_stock.Quantity," + "tb_stock.Commodity,1," + "now(),?," + "?,?," + "?"
				+ "from tb_stock WHERE tb_stock.ID=?";
		try {
			return this.update(sql, wareh.getUserName(), wareh.getAgency(), wareh.getWareh(), wareh.getRegisTime(),
					wareh.getId());
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}
	}

	public boolean updatWareh(int id) {
		String sql = "UPDATE tb_stock SET  State=0 WHERE ID=?";
		try {
			return this.update(sql, id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}
	}

	public boolean updatWarehs(int id) {
		String sql = "UPDATE tb_wareh SET  State=0 WHERE ID=?";
		try {
			return this.update(sql, id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}
	}
	//更改仓库
	public boolean updatWare(int id, String data) {
		String sql = "UPDATE tb_wareh SET  Wareh=? WHERE ID=?";
		try {
			return this.update(sql, data, id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}
	}
}
