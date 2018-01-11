package cn.com.lk.service;

import java.io.Serializable;

import cn.com.lk.pojo.Page;

public interface BaseService<T> {
	Page<T> getOnePage(Class<T> claszz, Integer index, Integer max);
	
	void deleteById(Class<T> clazz, Serializable id);
	
	T getById(Class<T> clazz, Serializable id);
}
