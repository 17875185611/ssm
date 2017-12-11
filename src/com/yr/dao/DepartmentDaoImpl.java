package com.yr.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yr.entry.Department;
import com.yr.mapper.DepartmentMapper;

@Component
public class DepartmentDaoImpl implements DepartmentDao{

	@Autowired
	private DepartmentMapper departmentMapper;
	
	@Override
	public List<Department> queryDepartment() {
		return departmentMapper.queryDepartment();
	}

	@Override
	public void deleteDepa(int id) {
		departmentMapper.deleteDepa(id);
	}

	@Override
	public void addDepa(String department) {
		departmentMapper.addDepa(department);
	}

	@Override
	public void deleteDepaForId(int id) {
		departmentMapper.deleteDepaForId(id);
	}

	@Override
	public void updateDepa(Department department) {
		departmentMapper.updateDepa(department);
	}

	@Override
	public Department queryOneDepartment(int id) {
		return departmentMapper.queryOneDepartment(id);
	}
}
