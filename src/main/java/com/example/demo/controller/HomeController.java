package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.UserEntity;
import com.example.demo.service.UserService;

@Controller
@RequestMapping("/home")
public class HomeController {

	@Autowired
	private UserService userServiceImpl;

	@RequestMapping(value = "hello1", method = RequestMethod.GET)
	@ResponseBody
	public String hello1() {
		List<UserEntity> users = userServiceImpl.getAll();
		return "hello1-" + users.size();
		// UserEntity user = userServiceImpl.selectUserByName("fangyt");
		// return homeServiceImpl.getHello(user.getUserName(),
		// user.getPassWord(), user.getUserSex());
	}

	@RequestMapping(value = "hello2", method = RequestMethod.GET)
	@ResponseBody
	public String hello2() {
		List<UserEntity> users = userServiceImpl.getAll2();
		return "hello2-" + users.size();
		// UserEntity user = userServiceImpl.selectUserByName("fangyt");
		// return homeServiceImpl.getHello(user.getUserName(),
		// user.getPassWord(), user.getUserSex());
	}
}
