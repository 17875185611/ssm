package com.yr.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yr.entry.Emp;
import com.yr.mapper.EmpMapper;

@Component
public class EmpDaoImpl implements EmpDao{

	@Autowired
	private EmpMapper empMapper;
	
	public List<Emp> queryAll(){
		
		return empMapper.queryAll();
	}
	
	@Override
	public void addEmp(Emp emp) {
		empMapper.addEmp(emp);
	}

	@Override
	public Emp queryEmp(int id) {
		return empMapper.queryEmp(id);
	}

	@Override
	public void updateEmp(Emp emp) {
		empMapper.updateEmp(emp);
	}

	@Override
	public void deleteEmp(int id) {
		empMapper.deleteEmp(id);
	}

	@Override
	public int empDepaCount(int id) {
		return empMapper.empDepaCount(id);
	}

	@Override
	public void deleteEmp2(int id) {
		empMapper.deleteEmp2(id);
	}
}
