package com.exzeo.spark.daoImpl;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.exzeo.spark.dao.UserDAO;
import com.exzeo.spark.model.User;

@Repository("userDAO")
public class UserDAOImpl extends BaseDAOImpl<User, Long> implements UserDAO {
	
	@Autowired
	SessionFactory sessionFactory;
	
	public UserDAOImpl() {
		super(User.class);
	}

	public User findUserByUsername(String username) {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(User.class);
		crit.add(Restrictions.eq("contactNumber", username));
		User user = (User) crit.uniqueResult();
		return user;
	}
}