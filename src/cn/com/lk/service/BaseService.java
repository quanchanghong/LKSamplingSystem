package cn.com.lk.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import cn.com.lk.pojo.Admin;
import cn.com.lk.pojo.Area;
import cn.com.lk.pojo.Industry;
import cn.com.lk.pojo.Page;
import cn.com.lk.pojo.ProductQuestion;
import cn.com.lk.pojo.Species;
import cn.com.lk.pojo.User;

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
	
	Admin getAdminByName(String adminName) throws Exception;
	
	User getUserByName(String userName) throws Exception;
	
	List<ProductQuestion> getAllProductQuestionList() throws Exception;
	
}
