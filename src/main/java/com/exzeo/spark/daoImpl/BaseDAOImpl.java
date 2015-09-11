package com.exzeo.spark.daoImpl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.exzeo.spark.dao.BaseDAO;

@SuppressWarnings("unchecked")
@Repository
public class BaseDAOImpl<T, PK extends Serializable> implements BaseDAO<T, PK> {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	protected Class<T> entityClass;
	
	public BaseDAOImpl(Class<T> entity) {
	    this.entityClass = entity;
	}
	
	// Default Constructor
	public BaseDAOImpl(){
		
	}
	
	public T findById(Long id) {
		
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(entityClass);
		crit.add(Restrictions.eq("id", id));
		
		return (T) crit.list().get(0);
	}

	public void deleteById(Long id) {
		
		// find the record.
		T entity = findById(id);
		
		// Delete it.
		this.sessionFactory.getCurrentSession().delete(entity);
	}
	
	public void delete(T entity) {
		this.sessionFactory.getCurrentSession().delete(entity);
	}
	
	public void saveOrUpdate(T entity) {		
		this.sessionFactory.getCurrentSession().saveOrUpdate(entity);
	}

	public List<T> getAllRecords() {
		Criteria crit = this.sessionFactory.getCurrentSession().createCriteria(entityClass);
		return crit.list();
	}

	public void refreshEntity(T entity) {
		sessionFactory.getCurrentSession().refresh(entity);
	}

	public void evictFromSession(T entity) {
		sessionFactory.getCurrentSession().evict(entity);		
	}
}