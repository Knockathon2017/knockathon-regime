package com.exzeo.spark.dao;

import com.exzeo.spark.model.User;

public interface UserDAO extends BaseDAO<User, Long> {
	
	public User findUserByUsername(String username);
}