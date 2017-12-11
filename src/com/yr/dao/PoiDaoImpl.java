package com.yr.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yr.entry.User;
import com.yr.mapper.PoiMapper;

@Repository
public class PoiDaoImpl implements PoiDao{

	@Autowired
	private PoiMapper poiMapper;

	@Override
	public void addUser(User user) {
         poiMapper.addUser(user);		
	}

	@Override
	public List<User> queryAll() {
		// TODO Auto-generated method stub
		return poiMapper.queryAll();
	}
}
