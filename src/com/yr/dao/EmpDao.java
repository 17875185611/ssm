package com.yr.dao;

import java.util.List;

import com.yr.entry.Emp;

public interface EmpDao {

	List<Emp> queryAll();
	
	void addEmp(Emp emp);
	
	Emp queryEmp(int id);
	
	void updateEmp(Emp emp);
	
	void deleteEmp(int id);
	
	void deleteEmp2(int id);
	
    int empDepaCount(int id);
	
}
