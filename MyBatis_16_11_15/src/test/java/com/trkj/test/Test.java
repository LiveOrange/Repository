package com.trkj.test;

import java.io.IOException;
import java.io.Reader;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.trkj.dao.IDeptDAO;
import com.trkj.pojo.Emp;

public class Test {
	public static void main(String[] args) {
		
		try {
			// 读取Config.xml核心配置文件
			Reader reader = Resources.getResourceAsReader("Config.xml");
			// 创建工厂构造器
			SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
			// 创建 Session工厂
			SqlSessionFactory factory = builder.build(reader);
			// 打开Session
			SqlSession session = factory.openSession();
			try {
				IDeptDAO deptDAO = session.getMapper(IDeptDAO.class);
				//获取一个员工
				List<Emp> list1 = deptDAO.findDept();
				for (Emp d : list1) {
					System.out.println(d.toString());
				}
				//找出所有员工 
				List<Emp> list2 = deptDAO.findEmp();
				for (Emp d : list2) {
					System.out.println(d.toString());
				}
				// 提交事务
				session.commit();
			} catch (Exception e) {
				e.printStackTrace();
				session.rollback();
			} finally {
				session.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
