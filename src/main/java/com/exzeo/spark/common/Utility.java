package com.exzeo.spark.common;

import org.springframework.security.core.context.SecurityContextHolder;

import com.exzeo.spark.model.User;

public class Utility {
	
	public static User getCurrentUser() {		
		try {
			return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		} catch (ClassCastException e) {
			return null;
		}	
	}
}