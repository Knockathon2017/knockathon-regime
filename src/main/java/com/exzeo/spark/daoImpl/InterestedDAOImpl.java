package com.exzeo.spark.daoImpl;

import org.springframework.stereotype.Repository;

import com.exzeo.spark.dao.InterestedDAO;
import com.exzeo.spark.model.Idea;
import com.exzeo.spark.model.Interested;
import com.exzeo.spark.model.User;

@Repository("interestedDAO")
public class InterestedDAOImpl extends BaseDAOImpl<Interested, Long> implements InterestedDAO {

	@Override
	public void getInterested(User user, Idea idea) {
		Interested interested = new Interested();
		interested.setUser(user);
		interested.setIdea(idea);
		saveOrUpdate(interested);
	}
	
	
}