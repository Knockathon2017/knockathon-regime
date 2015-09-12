package com.exzeo.spark.controller;

import static com.exzeo.spark.common.Constant.SUCCESS_RESPONSE;

import org.springframework.web.bind.annotation.*;

import com.exzeo.spark.model.User;

@RestController
public class BaseController {

	@RequestMapping(value="/signup", method={RequestMethod.GET})
	public @ResponseBody String signUp(@RequestBody User user) {
        return SUCCESS_RESPONSE;
	}
	
	
}
