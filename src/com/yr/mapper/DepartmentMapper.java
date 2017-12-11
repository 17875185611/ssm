package com.yr.mapper;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;
import com.yr.entry.Department;

@MapperScan
public interface DepartmentMapper {

	public void deleteDepa(int id);

	public List<Department> queryDepartment();
	
	public Department queryOneDepartment(int id);
	
	public void addDepa(String department);
	
	public void deleteDepaForId(int id);
	
	public void updateDepa(Department department);
}
