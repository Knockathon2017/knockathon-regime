package com.exzeo.spark.controller;

import static com.exzeo.spark.common.Constant.SUCCESS_RESPONSE;

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
