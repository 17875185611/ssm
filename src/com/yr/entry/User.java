package com.yr.entry;

public class User {

	private int id;
	private String name;
	private int age;
	private int pwd;
	private int sex;
	private String phone;
	private String addr;
	private String url;
	
	public User() {
		super();
	}
	public User(int id, String name, int age, int pwd, int sex, String phone, String addr, String url) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.pwd = pwd;
		this.sex = sex;
		this.phone = phone;
		this.addr = addr;
		this.url = url;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getPwd() {
		return pwd;
	}
	public void setPwd(int pwd) {
		this.pwd = pwd;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", age=" + age + ", pwd=" + pwd + ", sex=" + sex + ", phone="
				+ phone + ", addr=" + addr + ", url=" + url + "]";
	}
}
