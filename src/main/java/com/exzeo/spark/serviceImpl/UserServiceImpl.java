package com.exzeo.spark.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exzeo.spark.dao.UserDAO;
import com.exzeo.spark.service.UserService;

@Service("userService")
@Transactional(readOnly=true)
public class UserServiceImpl implements UserService, UserDetailsService {
	
	@Autowired
	private UserDAO userDAO;
	
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return userDAO.findUserByUsername(username);
	}	
	
}