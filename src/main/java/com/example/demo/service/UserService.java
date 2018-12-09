package com.example.demo.service;

import java.util.List;

import com.example.demo.model.User;
import com.github.pagehelper.Page;

public interface UserService {
	public List<User> selectAll();
	
	public List<User> selectAll2();
	
    public Page<User> findByPage(int pageNo, int pageSize);
}
