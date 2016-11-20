package com.trkj.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.trkj.pojo.Emp;

public interface IDeptDAO {

	public List<Emp> findDept();
	
	//薪水在2000~3000之间员工
	
	public List<Emp> findEmp();
	
}
