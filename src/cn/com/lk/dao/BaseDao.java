package cn.com.lk.dao;

import java.io.Serializable;
import java.util.List;
import cn.com.lk.pojo.Page;

public interface BaseDao<T> {
	List<T> getAll();
	
	Page<T> getOnePage(Class<T> claszz, Integer index, Integer max);
	
	void deleteById(Class<T> clazz, Serializable id);
	
	T getById(Class<T> clazz, Serializable id);
	
	List<T> getAllEntityByType(Class<T> claszz);
}
