package com.exzeo.spark.service;

import com.exzeo.spark.model.Idea;
import com.exzeo.spark.model.User;

public interface InterestedService {
	
	public void getInterested(User user, Idea idea);
	
}