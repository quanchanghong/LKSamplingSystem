package cn.com.lk.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.lk.dao.AreaDao;
import cn.com.lk.pojo.AIS;
import cn.com.lk.pojo.Area;
import cn.com.lk.pojo.Page;
import cn.com.lk.service.AreaService;

@Transactional
@Service
public class AreaServiceImpl extends BaseServiceImpl<Area> implements AreaService {
	
	@Autowired
	private AreaDao areaDao;

	@Override
	public List<Area> getAll() {
		return areaDao.getAll();
	}

	@Override
	public Page<Area> searchByName(String areaName) throws Exception {
		return areaDao.searchByName(areaName);
	}

}
