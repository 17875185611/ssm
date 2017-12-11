package com.yr.entry;

public class Department {

	private int depaid;
	private String departmentName;

	public Department() {
		super();
	}

	public Department(int depaid) {
		super();
		this.depaid = depaid;
	}

	public Department(int depaid, String departmentName) {
		super();
		this.depaid = depaid;
		this.departmentName = departmentName;
	}

	public int getDepaid() {
		return depaid;
	}

	public void setDepaid(int depaid) {
		this.depaid = depaid;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	@Override
	public String toString() {
		return "Department [depaid=" + depaid + ", departmentName=" + departmentName + "]";
	}
}
