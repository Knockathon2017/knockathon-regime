package com.exzeo.spark.dao;

import com.exzeo.spark.model.Idea;
import com.exzeo.spark.model.Interested;
import com.exzeo.spark.model.User;

public interface InterestedDAO extends BaseDAO<Interested, Long> {
	
	public void getInterested(User user, Idea idea);
}