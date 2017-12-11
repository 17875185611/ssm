package com.yr.dao;

import java.util.List;

import com.yr.entry.Department;

public interface DepartmentDao {

	List<Department> queryDepartment();
	
	void deleteDepa(int id);
	
	void addDepa(String department);
	
	void deleteDepaForId(int id);
	
	void updateDepa(Department department);
	
	Department queryOneDepartment(int id);
}
