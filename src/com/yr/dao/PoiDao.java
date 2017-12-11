package com.yr.dao;

import java.util.List;

import com.yr.entry.User;

public interface PoiDao {

	public void addUser(User user);
	public List<User> queryAll();
}
