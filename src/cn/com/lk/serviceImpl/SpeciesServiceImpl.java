package cn.com.lk.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.lk.dao.speciesDao;
import cn.com.lk.pojo.Page;
import cn.com.lk.pojo.Species;
import cn.com.lk.service.SpeciesService;

@Transactional
@Service("speciesService")
public class SpeciesServiceImpl extends BaseServiceImpl<Species> implements SpeciesService {
	
	@Autowired
	@Qualifier("speciesDao")
	private speciesDao speciesDao;

	@Override
	public Page<Species> searchByName(String speciesName) throws Exception {
		return speciesDao.searchByName(speciesName);
	}

}
