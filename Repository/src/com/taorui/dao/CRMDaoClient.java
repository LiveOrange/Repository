package com.taorui.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import com.taorui.entities.*;

/**
 * 客户联系
 */
public class CRMDaoClient extends BaseDAO {
	public CRMDaoClient() {
		super("jdbc/test");
	}

	private class Client4RowMapper implements RowMapper<Client4> {
		@Override
		public Client4 rowMap(ResultSet rs) throws SQLException {
			Client4 client = new Client4();
			client.setClientTime(rs.getDate("Client_StorageTime"));
			client.setClientOrder(rs.getString("Client_Order"));
			client.setClientId(rs.getInt("Client_Id"));
			client.setPhoneTime(rs.getDate("Phone_Time"));
			client.setThedoorTime(rs.getDate("Thedoor_Time"));
			return client;
		}
	}

	// 1.1、更新手机联系时间
	public boolean deptClientPhone(int id, String order) {
		String sql = "update  tb_client set Client_Order=?, Phone_Time=now() where Client_Id=?";
		return this.update(sql, order, id);
	}

	// 1.2、更新上门联系时间
	public boolean deptClientThedoor(int id, String order) {
		String sql = "update  tb_client set  Client_Order=?, Thedoor_Time=now() where Client_Id=?";
		return this.update(sql, order, id);
	}

	// 2、公海查询
	public List<Client4> findAllClient() {
		String sql = "select * from tb_client  WHERE Client_Order!='公司公海'";
		try {
			return this.query(sql, new Client4RowMapper());
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}
	}

	// 4、修改状态
	public boolean updateClientOrder(int id, String data) {
		String sql = "update  tb_client set  Client_Order=?  where Client_Id=?";
		return this.update(sql, data, id);
	}

	// 5、公海添加
	public boolean insertComsea(Comsea comsea) {
		String sql = "insert ignore into tb_comsea (Client_Id,Comsea_Reason,Comsea_loseTime) values (?,?,now())";
		try {
			return this.update(sql, comsea.getClientID(), comsea.getReason());
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}
	}
	//6、客户月跳数加1
	public boolean updataConsum(int id){
		String sql="update tb_user set User_Order=User_Order+1 where User_Id =?";
		return this.update(sql, id);
	}
	//7、删除公海信息
	public boolean deletConsum(int id){
		String sql =" delete from tb_comsea where Comsea_ID=?";
		return this.update(sql, id);
	}
	//8、修改客户
	public boolean updataClient(int id ,String name,int clientid){
		String sql="update tb_client set Client_Source='公海转入' , "
				+ "User_Id=?,"
				+ "User_Name=?, "
				+ "Client_StorageTime=now(),"
				+ "Thedoor_Time=now(),"
				+ "Phone_Time=now(),"
				+ "Client_Order='服务中' "
				+ "where Client_Id =?";
		return this.update(sql,id,name,clientid);
	}
}
