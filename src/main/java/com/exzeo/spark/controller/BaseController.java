package com.exzeo.spark.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.exzeo.spark.common.ResponseUtil;
import com.exzeo.spark.model.User;
import com.exzeo.spark.service.UserService;

@RestController
public class BaseController {

    private static final Logger LOGGER = Logger.getLogger(BaseController.class);

    @Autowired
    UserService userService;

    @RequestMapping(value = "/signup", method = RequestMethod.POST, consumes = "application/json")
    public  @ResponseBody String signUp(@RequestBody User user, HttpServletRequest request, HttpServletResponse response) {
        LOGGER.info("Got request for sign up");
        try {	
            userService.saveUser(user);
            return ResponseUtil.SUCCESS;
        } catch (Exception e) {
            LOGGER.error("Problem while saving user ", e);
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return ResponseUtil.FAILURE;
        }
    }
}
