package cn.com.lk.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import cn.com.lk.pojo.Area;
import cn.com.lk.pojo.Industry;
import cn.com.lk.pojo.Page;
import cn.com.lk.pojo.Species;

public interface BaseService<T> {
	Page<T> getOnePage(Class<T> claszz, Integer index, Integer max);
	
	void deleteById(Class<T> clazz, Serializable id);
	
	T getById(Class<T> clazz, Serializable id);
	
	List<Species> getAllSpecies() throws Exception;

	List<Area> getAllArea() throws Exception;

	List<Industry> getAllIndustry() throws Exception;
	
	Map<String, Object> getAreaIndustrySpeciesMap() throws Exception;
	
	void update(T t);
	
	Integer save(T t);
	
	void saveOrUpdate(T t);
	
}
