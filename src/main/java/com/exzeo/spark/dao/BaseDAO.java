package com.exzeo.spark.dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDAO<T, PK extends Serializable> {
	
	public List<T> getAllRecords();	
	
	public T findById(Long id);	
	
	public void deleteById(Long id);	
	
	public void delete(T entity);	
	
	public void saveOrUpdate(T entity);		
	
	public void refreshEntity(T entity);	
	
	public void evictFromSession(T entity);	
}