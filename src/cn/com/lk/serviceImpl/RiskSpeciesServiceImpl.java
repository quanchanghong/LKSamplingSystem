package cn.com.lk.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.lk.dao.RiskSpeciesDao;
import cn.com.lk.pojo.BaseSpecies;
import cn.com.lk.service.RiskSpeciesService;

@Transactional
@Service("riskSpeciesService")
public class RiskSpeciesServiceImpl extends BaseServiceImpl<BaseSpecies> implements RiskSpeciesService {

	@Autowired
	@Qualifier("riskSpeciesDao")
	private RiskSpeciesDao riskSpeciesDao;

	@Override
	public Integer saveObjecList(List<BaseSpecies> baseSpeciesList) throws Exception {
		return riskSpeciesDao.saveObjecList(baseSpeciesList);
	}

}
