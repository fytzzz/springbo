package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.conf.db.DB;
import com.example.demo.model.User;
import com.example.demo.service.impl.UserServiceImpl;

@Controller
@RequestMapping("/home")
public class HomeController {

	@Autowired
	Environment env;
	
	@Autowired
	private UserServiceImpl userServiceImpl;

	@RequestMapping(value = "hello1", method = RequestMethod.GET)
	@ResponseBody
	public String hello1() {
		List<User> users = userServiceImpl.selectAll();
		System.out.println(Thread.currentThread().getName() +"---" + env.getProperty("user.name") + new DB().getName());
		return "hello1-" + users.size();
		// UserEntity user = userServiceImpl.selectUserByName("fangyt");
		// return homeServiceImpl.getHello(user.getUserName(),
		// user.getPassWord(), user.getUserSex());
	}

	@RequestMapping(value = "hello2", method = RequestMethod.GET)
	@ResponseBody
	public String hello2() {
		List<User> users = userServiceImpl.selectAll();
		System.out.println(Thread.currentThread().getName().toString());
		return "hello2-" + users.size();
		// UserEntity user = userServiceImpl.selectUserByName("fangyt");
		// return homeServiceImpl.getHello(user.getUserName(),
		// user.getPassWord(), user.getUserSex());
	}
}
