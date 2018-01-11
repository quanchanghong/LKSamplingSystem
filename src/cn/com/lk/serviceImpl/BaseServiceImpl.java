package cn.com.lk.serviceImpl;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.lk.dao.BaseDao;
import cn.com.lk.pojo.Page;
import cn.com.lk.service.BaseService;

@Transactional
@Service("baseService")
public class BaseServiceImpl<T> implements BaseService<T> {
	
	@Autowired
	@Qualifier(value="baseDaoImpl")
	private BaseDao<T> baseDao;
	
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

}
