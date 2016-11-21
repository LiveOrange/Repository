package com.taorui.dao;

import java.sql.*;
import java.util.*;

import com.taorui.entities.*;

public class CRMDaoXmw extends BaseDAO {
	public CRMDaoXmw() {
		super("jdbc/test");
	}

	private class DeptRowMapper implements RowMapper<Dept> {
		@Override
		public Dept rowMap(ResultSet rs) throws SQLException {
			Dept dept = new Dept();
			dept.setDeptID(rs.getInt("Dept_TID"));
			dept.setDeptName(rs.getString("Dept_Name"));
			dept.setRemark(rs.getInt("Remark"));
			return dept;
		}
	}
	//用户查询
	private class User1RowMapper implements RowMapper<User1> {
		@Override
		public User1 rowMap(ResultSet rs) throws SQLException {
			User1 user = new User1();
			user.setId(rs.getInt("User_Id"));
			user.setUserName(rs.getString("User_Name"));
			user.setDeptName(rs.getString("Dept_Name"));
			user.setJob(rs.getInt("User_Post"));
			user.setEmpState(rs.getInt("User_EmpState"));
			return user;
		}
	}
	//用户登录
	private class UserRowMapper implements RowMapper<User> {

		@Override
		public User rowMap(ResultSet rs) throws SQLException {
			User user = new User();
			user.setId(rs.getInt("User_Id"));
			user.setUserName(rs.getString("User_Name"));
			user.setPassword(rs.getString("User_Password"));
			user.setJob(rs.getInt("User_Post"));
		//	user.setIdcard(rs.getString("User_IDCard"));
			user.setDeptid(rs.getInt("User_Dept"));
			user.setEmpState(rs.getInt("User_EmpState"));
			return user;
		}

	}

	// 1、部门修改
	public boolean updateDept(Dept dept) {
		String sql = "update tb_dept set Dept_Name=? where Dept_TID=?";
		try {
			return this.update(sql, dept.getDeptName(), dept.getDeptID());
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}
	}

	// 2、部门添加
	public boolean insertDept(Dept dept) {
		String sql = "insert ignore into tb_dept (Dept_Name,Remark) values (?,?);";
		try {
			return this.update(sql, dept.getDeptName(), dept.getRemark());
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}
	}

	// 3、部门查询
	public List<Dept> findAllDept() {
		String sql = "select * from tb_dept WHERE Remark=1  order by Dept_TID asc ";
		try {
			return this.query(sql, new DeptRowMapper());
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}
	}

	// 4.1、部门总个数
	public int count() {
		String sql = "select count(*) a from tb_dept WHERE Remark=1";
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
	public int funtcount() {
		String sql = "select count(*) a from tb_user WHERE User_EmpState=1";
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
	// 4.2、部门总个数
	public int count(int id) {
		String sql = "select count(*) a from tb_user WHERE  User_EmpState=1 and User_Dept=?";
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
	// 5、分页查询
	public List<Dept> getDept(int curpage, int pagesize) {
		String sql = "select * from tb_dept WHERE Remark=1 order by Dept_TID asc limit ?,?";
		try {
			return this.query(sql, new DeptRowMapper(), (curpage - 1) * pagesize, pagesize);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}
	}

	// 6、部门删除
	public boolean deptDel(Dept dept) {
		String sql = "update tb_dept set Dept_Name=?,Remark=? where Dept_TID=?";
		try {
			return this.update(sql, dept.getDeptName(), dept.getRemark(), dept.getDeptID());
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}

	}

	// 7、账户注册
	public boolean insertUser(User user) {
		String sql = "insert ignore into tb_user" + "(User_Name,User_Password," + "User_Post,User_IDCard,"
				+ "User_Dept,User_Address," + "User_RegisTime,User_EmpState) " + "values (?,?,?,?,?,?,?,?);";
		System.out.println("2" + user.getUserName() + ":" + user.getPassword() + ":" + user.getIdcard() + ":"
				+ user.getJob() + ":" + user.getDeptid());
		try {
			return this.update(sql, user.getUserName(), user.getPassword(), user.getJob(), user.getIdcard(),
					user.getDeptid(), user.getAddress(), user.getRegisTime(), user.getEmpState());
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}
	}

	// 7、账户登录
	public List<User> usersQuery(User user) {
		String sql = "select * from tb_user where User_Name=? " + " and User_Password=? " + " and User_EmpState=1";
		try {
			return this.query(sql, new UserRowMapper(), user.getUserName(), user.getPassword());
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}
	}

	// 8、总数查询
	public int UserCount() {
		String sql = "select count(*) a from tb_user";
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

	// 9、账户查询
	public List<User1> findUser1ByPage(int curpage, int pagesize) {
		String sql = "select * from tb_user e inner join tb_dept d on e.User_Dept=d.Dept_TID limit ?,?";
		try {
			return this.query(sql, new User1RowMapper(), (curpage - 1) * pagesize, pagesize);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}
	}

	// 10、账户账户
	public boolean updateUser(User1 user) {
		String sql = "update  tb_user set User_Name=?,"
									+ "User_Post=?,"
									+ "User_Dept=?,"
									+ "User_EmpState=?"
									+ " where User_Id=?";
		try {
			return this.update(sql, user.getUserName(),
									user.getJob(),
									user.getDeptid(),
									user.getEmpState(),
									user.getId());
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}
	}
	public List<User1> finClientByPage() {
		String sql = "select * from tb_user e inner join tb_dept d on e.User_Dept=d.Dept_TID and User_EmpState=1";
		try {
			return this.query(sql, new User1RowMapper());
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}
	}
}
