package com.exzeo.spark.controller;

import static com.exzeo.spark.common.Constant.SUCCESS_RESPONSE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.exzeo.spark.model.User;
import com.exzeo.spark.service.UserService;

@RestController
public class BaseController {
	
	@Autowired
	UserService userService;

	@RequestMapping(value="/signup", method=RequestMethod.POST, consumes="application/json")
	public @ResponseBody String signUp(@RequestBody User user) {
		userService.saveUser(user);		
		return SUCCESS_RESPONSE;
	}
	
}
