package com.exzeo.spark.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.testng.log4testng.Logger;

import com.exzeo.spark.common.Constant;
import com.exzeo.spark.dao.InterestedDAO;
import com.exzeo.spark.model.Idea;
import com.exzeo.spark.model.User;
import com.exzeo.spark.service.InterestedService;

@Service("interestedService")
@Transactional(readOnly=true)
public class InterestedServiceImpl implements InterestedService {
	
	private Logger logger = Logger.getLogger(InterestedServiceImpl.class);
	
	@Autowired
	private InterestedDAO interestedDAO;
	
	public void getInterested(User user, Idea idea) {
		
		if (!user.getRole().equals(Constant.USER_ROLE_IGINITOR)) {
			logger.error("Spark can be interested in his own idea.");
			return;
		}
		
		interestedDAO.getInterested(user, idea);
	}
	
}