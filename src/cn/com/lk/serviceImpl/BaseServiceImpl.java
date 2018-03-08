package cn.com.lk.serviceImpl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import net.sf.ehcache.Element;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.lk.constant.EhcacheConstant;
import cn.com.lk.dao.BaseDao;
import cn.com.lk.pojo.Admin;
import cn.com.lk.pojo.Area;
import cn.com.lk.pojo.Industry;
import cn.com.lk.pojo.Page;
import cn.com.lk.pojo.ProductQuestion;
import cn.com.lk.pojo.Species;
import cn.com.lk.pojo.User;
import cn.com.lk.service.BaseService;
import cn.com.lk.utils.EhcacheUtils;

@Transactional
@Service("baseService")
public class BaseServiceImpl<T> implements BaseService<T> {
	
	@Autowired
	@Qualifier(value="baseDao")
	private BaseDao<T> baseDao;
	
	public void setBaseDao(BaseDao<T> baseDao) {
		this.baseDao = baseDao;
	}

	@Override
	public Page<T> getOnePage(Class<T> claszz, Integer index, Integer max) {
		return baseDao.getOnePage(claszz, index, max);
	}

	@Override
	public void deleteById(Class<T> clazz, Serializable id) {
		baseDao.deleteById(clazz, id);
	}

	@Override
	public T getById(Class<T> clazz, Serializable id) {
		return baseDao.getById(clazz, id);
	}

	@Override
	public void update(T t) {
		baseDao.update(t);
	}

	@Override
	public List<Species> getAllSpecies() throws Exception {
		return baseDao.getAllSpecies();
	}

	@Override
	public List<Area> getAllArea() throws Exception {
		return baseDao.getAllArea();
	}

	@Override
	public List<Industry> getAllIndustry() throws Exception {
		return baseDao.getAllIndustry();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getAreaIndustrySpeciesMap() throws Exception {
		
		Map<String, Object> map = null;

		Element element = EhcacheUtils.getElementByName(EhcacheConstant.CACHE_NAME_USER, EhcacheConstant.ELEMENT_NAME_AIS);
		if (element == null || element.isExpired()) {
			map = baseDao.getAreaIndustrySpeciesMap();
			EhcacheUtils.getCacheByName(EhcacheConstant.CACHE_NAME_USER).put(new Element(EhcacheConstant.ELEMENT_NAME_AIS, map));
		}else{
			map = (Map<String, Object>) element.getObjectValue();
		}
		
		return map;
	}

	@Override
	public Integer save(T t) {
		return baseDao.save(t);
	}

	@Override
	public void saveOrUpdate(T t) {
		baseDao.saveOrUpdate(t);
	}

	@Override
	public Admin getAdminByName(String adminName) throws Exception {
		return baseDao.getAdminByName(adminName);
	}

	@Override
	public User getUserByName(String userName) throws Exception {
		return baseDao.getUserByName(userName);
	}

	@Override
	public List<ProductQuestion> getAllProductQuestionList() throws Exception {
		List<ProductQuestion> list = null;
		Element element = EhcacheUtils.getElementByName(EhcacheConstant.CACHE_NAME_USER, EhcacheConstant.ELEMENT_NAME_ALL_PRODUCTQUESTION);
		if (element == null || element.isExpired()) {
			list = baseDao.getAllProductQuestionList();
			EhcacheUtils.getCacheByName(EhcacheConstant.CACHE_NAME_USER).put(new Element(EhcacheConstant.ELEMENT_NAME_ALL_PRODUCTQUESTION, list));
		}else{
			list = (List<ProductQuestion>) element.getObjectValue();
		}
		return list;
	}

}
