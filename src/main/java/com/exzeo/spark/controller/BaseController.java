package com.exzeo.spark.controller;

import static com.exzeo.spark.common.Constant.SUCCESS_RESPONSE;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.exzeo.spark.model.User;

@RestController
public class BaseController {

	@RequestMapping(value="/signup", method=RequestMethod.POST)
	public @ResponseBody String signUp(@RequestBody User user) {
		
		
		return SUCCESS_RESPONSE;
	}
	
	
}
