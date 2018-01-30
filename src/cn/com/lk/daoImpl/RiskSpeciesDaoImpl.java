package cn.com.lk.daoImpl;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.com.lk.dao.RiskSpeciesDao;
import cn.com.lk.pojo.BaseSpecies;

@Repository("riskSpeciesDao")
public class RiskSpeciesDaoImpl extends BaseDaoImpl<BaseSpecies> implements RiskSpeciesDao {

	@Override
	public Integer saveObjecList(List<BaseSpecies> baseSpeciesList) throws Exception {
		
		Integer isSuccess = 1;
		try {
			if (baseSpeciesList != null && baseSpeciesList.size() > 0){
				for (BaseSpecies baseSpecies : baseSpeciesList) {
					this.save(baseSpecies);
				}
			}
		}catch(Exception e){
			isSuccess = -1;
			e.printStackTrace();
		}
		
		return isSuccess;
	}


}
