package com.yr.entry;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class Emp {

	private int id;
	@NotEmpty
	private String last_Name;
	@Email
	private String email;
	private String gender;
	private Department department;
	@Length(max=11)
	private String iphone;
	private String address;

	public Emp() {
		super();
	}

	public Emp(int id, String last_Name, String email, String gender, Department department, String iphone,
			String address) {
		super();
		this.id = id;
		this.last_Name = last_Name;
		this.email = email;
		this.gender = gender;
		this.department = department;
		this.iphone = iphone;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLast_Name() {
		return last_Name;
	}

	public void setLastName(String last_Name) {
		this.last_Name = last_Name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public String getIphone() {
		return iphone;
	}

	public void setIphone(String iphone) {
		this.iphone = iphone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Emp [id=" + id + ", lastName=" + last_Name + ", email=" + email + ", gender=" + gender + ", department="
				+ department + ", iphone=" + iphone + ", address=" + address + "]";
	}
}
