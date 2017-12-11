package com.yr.mapper;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import com.yr.entry.Emp;

@MapperScan
public interface EmpMapper {

	public List<Emp> queryAll();
	
	public void addEmp(Emp emp);
	
	public void updateEmp(Emp emp);
	
	public Emp queryEmp(int id);
	
	public void deleteEmp(int id);
	
	public void deleteEmp2(int id);
	
	public int empDepaCount(int id);
	
}
