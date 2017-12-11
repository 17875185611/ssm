package com.yr.hander;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yr.dao.DepartmentDaoImpl;
import com.yr.dao.EmpDaoImpl;
import com.yr.entry.Department;
import com.yr.entry.Emp;

@Controller
public class EmpHandle {

	@Autowired
	private EmpDaoImpl empDaoImpl;
	
	@Autowired
	private DepartmentDaoImpl departmentDaoImpl;

	@RequestMapping("/queryEmp")
	public String queryEmp(Map<String, Object> map) {
		List<Emp> list = empDaoImpl.queryAll();
		map.put("list", list);
		return "listEmp";
	}

	@RequestMapping("/queryDepa")
	public String queryDepartment(Map<String, Object> map) {
		List<Department> list = departmentDaoImpl.queryDepartment();
		map.put("list", list);
		return "registerEmp";
	}
	

	@RequestMapping(value = "/addEmp", method = RequestMethod.POST)
	public String addEmp(@Valid Emp emp,Errors emperror,Map<String, Object> map) {
		if (emperror.getErrorCount() > 0) {
			for (FieldError fieldError :emperror.getFieldErrors()) {
				System.out.println(fieldError.getField()+":"+fieldError.getDefaultMessage());
			}
			map.put("list", departmentDaoImpl.queryDepartment());
			return "registerEmp";
		}
		empDaoImpl.addEmp(emp);
		return "registerEmp_success";
	}

	@RequestMapping(value = "/queryOneDepa/{id}", method = RequestMethod.GET)
	public String qureyEmp(Map<String, Object> map, @PathVariable("id") Integer id) {
		Emp emp = empDaoImpl.queryEmp(id);
		map.put("emp", emp);
		return "updateEmp";
	}

	@ModelAttribute
	public void getEmp(@RequestParam(value = "id", required = false) Integer id, Map<String, Object> map) {
		if (id != null) {
			Emp emp = empDaoImpl.queryEmp(id);
			map.put("queryemp", emp);
		}
	}

	@RequestMapping(value = "/updateEmp", method = RequestMethod.PUT)
	public String testModelAttribute(@ModelAttribute(value = "queryemp") Emp emp) {
		empDaoImpl.updateEmp(emp);
		return "updateEmp_success";
	}

	@RequestMapping("/ajax")
	public @ResponseBody Map<String, Object> ajaxQueryEmp() {
		List<Department> list = departmentDaoImpl.queryDepartment();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		return map;
	}

	@RequestMapping(value = "/deleteEmp/{id}", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> deleteEmp(@PathVariable("id") Integer id) {
		empDaoImpl.deleteEmp(id);
		int count = empDaoImpl.empDepaCount(id);
		if (count == 0) {
			departmentDaoImpl.deleteDepa(id);
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("mark", "success");
		return map;
	}

	@RequestMapping(value = "/queryEmp/{id}", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> queryEmp(@PathVariable("id") Integer id) {
		Emp emp = empDaoImpl.queryEmp(id);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("emp", emp);
		return map;
	}
	
	/**
	 * 不自动绑定对象中的id 属性，另行处理
	 */
//	@InitBinder
//	public void initBinder(WebDataBinder dataBinder){
//		 dataBinder.setDisallowedFields("id");
//	}
}
