package com.xznu.edu.leave.base.dao;

import java.util.List;
import java.util.Map;

public interface BaseDao<T> {
	/**
	 * 添加对象
	 * @param t
	 * @return
	 */
	public T add(T t);
	/**
	 * 更新对象
	 * @param t
	 */
	public void update(T t);

	public T updates(T t);
	/**
	 * 根据id删除对象
	 * @param id
	 */
	public void delete(int id);
	/**
	 * 根据id加载对象
	 * @param id
	 * @return
	 */
	public T load(int id);
	/**
	 * 不分页列别查询
	 * @param hql
	 * @param args
	 * @return
	 */
	public List<T> listByAlias(String hql, Map<String, Object> alias);

    T findById(Integer id);

    public T getByParams(String hql, Map<String, Object> alias);
}
