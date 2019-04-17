package com.xznu.edu.leave.service;

import com.xznu.edu.leave.model.User;

import java.util.List;
import java.util.Map;

public interface BaseService<T> {
	    public void save(T entity);  
	  
	    public void update(T entity);

	    public void updates(T entity);

	    public void delete(int id);

	    T findById(int id);

	    public T getById(int id);  
	  
	    public List<T> getByHQL(String hql, Map<String, Object> alias); 
	    
	    public T getOneByHql(String hql, Map<String, Object> alias);

}
