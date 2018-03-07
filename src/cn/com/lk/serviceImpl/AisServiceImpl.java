package cn.com.lk.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.lk.dao.AisDao;
import cn.com.lk.pojo.AIS;
import cn.com.lk.pojo.Area;
import cn.com.lk.pojo.Industry;
import cn.com.lk.pojo.Species;
import cn.com.lk.service.AisService;

@Transactional
@Service("aisService")
public class AisServiceImpl extends BaseServiceImpl<AIS> implements AisService {
	
	@Autowired
	@Qualifier("aisDao")
	private AisDao aisDao;

	@Override
	public Map<String, Object> getAisEditMap(Integer id) throws Exception {
		Map<String, Object>  map= null;
		if (id <= 0){
			return map;
		}
		
		List<Species> speciesList = aisDao.getAllSpecies();
		List<Area> areaList = aisDao.getAllArea();
		List<Industry> industryList = aisDao.getAllIndustry();
		AIS ais = aisDao.getById(AIS.class, id);
		
		map = new HashMap<String, Object>();
		
		map.put("ais", ais);
		map.put("speciesList", speciesList);
		map.put("industryList", industryList);
		map.put("areaList", areaList);
		
		return map;
	}

	@Override
	public Integer queryAisBeforeSave(AIS ais) throws Exception {
		return aisDao.queryAisBeforeSave(ais);
	}
	
}
