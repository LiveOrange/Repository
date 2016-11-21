package com.taorui.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.taorui.entities.Comsea;
import com.taorui.entities.User1;

/**
 * 公海客户
 */
public class CRMDaoContact extends BaseDAO {
	public CRMDaoContact() {
		super("jdbc/test");
	}

	// ComseaRowMapper
	private class UserRowMapper implements RowMapper<User1> {
		@Override
		public User1 rowMap(ResultSet rs) throws SQLException {
			User1 user = new User1();
			user.setOrder(rs.getInt("User_Order"));
			return user;
		}
	}

	private class ComseaRowMapper implements RowMapper<Comsea> {
		@Override
		public Comsea rowMap(ResultSet rs) throws SQLException {
			Comsea comsea = new Comsea();
			comsea.setComseaID(rs.getInt("Comsea_ID"));
			comsea.setClientID(rs.getInt("Client_Id"));
			comsea.setClientfirm(rs.getString("Client_firm"));
			comsea.setClientProd(rs.getString("Client_Prod"));
			comsea.setClientPhone(rs.getString("Client_Phone"));
			comsea.setData(rs.getDate("Comsea_loseTime"));
			comsea.setReason(rs.getString("Comsea_Reason"));
			return comsea;
		}
	}

	// 1、公海统计
	public int contactCount() {
		String sql = "select count(*) a from tb_comsea";
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

	// 2、接单统计
	public int contactOrder(int id) {
		String sql = "select count(*) a from tb_client WHERE User_Id=?" + " and Client_Order='服务中'";
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

	// 3、本月接单数
	public List<User1> usersQuery(int id) {
		String sql = "select * FROM tb_user WHERE User_Id=?";
		try {
			return this.query(sql, new UserRowMapper(), id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}
	}

	// 4、
	public List<Comsea> finClientByPage(int curpage, int pagesize) {
		String sql = "select * from tb_comsea e inner join tb_client d on e.Client_Id=d.Client_Id  limit ?,?;";
		try {
			return this.query(sql, new ComseaRowMapper(), (curpage - 1) * pagesize, pagesize);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}
	}
	//5、
	public int finClientCount(Comsea comsea ) {
		String sql = "select Client_Order,count(*) a  "
					+ "from tb_client where  Client_Order='公司公海' "
					+ "and (Client_LoginID=?"
					+ " or Client_Prod=? "
					+ " or Client_Id=? "
					+ " or Client_Name=?) "
					
					+ " group by Client_Order "; 
		try {
			return this.queryOne(sql,new RowMapper<Integer>() {

				@Override
				public Integer rowMap(ResultSet rs) throws SQLException {
					return rs.getInt("a");
				}
			},comsea.getLoginID(),comsea.getClientProd(),
			  comsea.getClientId(),comsea.getClientName());
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}
	}
	//6、
	public List<Comsea> finClientByPage(Comsea comsea,int curpage, int pagesize) {
	String sql = "select * from tb_comsea"
			+ " e inner join tb_client d on"
			+ " e.Client_Id=d.Client_Id  HAVING "
			+ " (d.Client_LoginID=?"
			+ " or d.Client_Prod=?"
			+ " or d.Client_Name=?"
			+ " or d.Client_Id=? ) limit ?,?"; 
	try {
		return this.query(sql, new ComseaRowMapper(),
				comsea.getLoginID(),
				comsea.getClientProd(),
				comsea.getClientName(),
				comsea.getClientId(),
			   (curpage - 1) * pagesize, pagesize);
	} catch (Exception e) {
		e.printStackTrace();
		throw new DAOException(e);
	}
}
}
