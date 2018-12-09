package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.conf.multids.Datasource;
import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserMapper userMapper;

	@Override
	@Datasource("datasource1")
	public List<User> selectAll() {
		return userMapper.selectAll();
	}

	@Override
	@Datasource("datasource2")
	public List<User> selectAll2() {
		return userMapper.selectAll();
	}
	
	@Override
    public Page<User> findByPage(int pageNo, int pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        return userMapper.findByPage();
    }
}
