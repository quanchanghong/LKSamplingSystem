package cn.com.lk.serviceImpl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.lk.dao.AisDao;
import cn.com.lk.pojo.AIS;
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
		
		
		return null;
	}

}
