package com.yr.mapper;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import com.yr.entry.User;

@MapperScan
public interface PoiMapper {

	public void addUser(User user);
	public List<User> queryAll();
}
