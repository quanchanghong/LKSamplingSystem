package cn.com.lk.daoImpl;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.com.lk.dao.RiskSpeciesDao;
import cn.com.lk.pojo.BaseSpecies;
import cn.com.lk.pojo.Page;
import cn.com.lk.pojo.Species;

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

	@Override
	public Page<BaseSpecies> searchByName(String baseSpeciesName) {
		Page<BaseSpecies> page = new Page<BaseSpecies>();
		String sql = "from BaseSpecies where customName like '%" + baseSpeciesName + "%' or source like '%" + baseSpeciesName + "%'";
		List<BaseSpecies> list = this.getCurrentSession().createQuery(sql).list();
		
		page.setCurrentPage(1);
		page.setPageSize(50);
		page.setPageTotal(list.size());
		
		if (list != null && list.size() >0){
			page.setList(list);
		}
		return page;
	}


}
