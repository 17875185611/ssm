package com.yr.hander;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yr.dao.DepartmentDaoImpl;
import com.yr.dao.EmpDaoImpl;
import com.yr.entry.Department;

@Controller
public class DepaHandle {

	@Autowired
	private DepartmentDaoImpl departmentDaoImpl;
	
	@Autowired
	private EmpDaoImpl empDaoImpl;
	
	@RequestMapping("/queryDepa2")
	public String queryDepartment2(Map<String, Object> map) {
		List<Department> list = departmentDaoImpl.queryDepartment();
		map.put("list", list);
		return "listDepa";
	}
	
	@RequestMapping("/queryOneDepartment/{id}")
	public @ResponseBody Map<String, Object> queryOneDepartment(@PathVariable("id") Integer id) {
		Department department = departmentDaoImpl.queryOneDepartment(id);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("mark", "success");
		map.put("department", department);
		return map;
	}
	
	@RequestMapping(value="/addDepa/{name}", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> addDepa(@PathVariable("name") String departmentName){
		departmentDaoImpl.addDepa(departmentName);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("mark", "success");
		return map;
	}
	
	@RequestMapping(value="/deleteDepaForId/{id}", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> deleteDepaForId(@PathVariable("id") Integer id){
		departmentDaoImpl.deleteDepaForId(id);
		empDaoImpl.deleteEmp2(id);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("mark", "success");
		return map;
	}
	
	@RequestMapping(value="/updateDepaForId/{id}", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> updateDepaForId(@PathVariable("id") Integer depaid,@RequestParam("name") String departmentName){
		Department department = new Department(depaid, departmentName);
		departmentDaoImpl.updateDepa(department);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("mark", "success");
		return map;
	}
}
