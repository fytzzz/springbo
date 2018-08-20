package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.conf.multids.Datasource;
import com.example.demo.mapper.UserMapper;
import com.example.demo.model.UserEntity;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserMapper userMapper = null;

	@Override
	@Datasource("datasource1")
	public List<UserEntity> getAll() {
		return userMapper.getAll();
	}

	@Override
	@Datasource("datasource2")
	public List<UserEntity> getAll2() {
		return userMapper.getAll();
	}
}
