package cn.com.lk.daoImpl;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.com.lk.dao.AisDao;
import cn.com.lk.pojo.AIS;

@Repository("aisDao")
public class AisDaoImpl extends BaseDaoImpl<AIS> implements AisDao {
	
	
	@Override
	public Integer queryAisBeforeSave(AIS ais) {
		List<AIS> list = this.getCurrentSession().createQuery("from AIS where area.areaId=" + ais.getArea().getAreaId() + " and industry.industryId=" + ais.getIndustry().getIndustryId() + " and species.speciesId=" + ais.getSpecies().getSpeciesId()+"").list();
		if (list.size() > 0 && list != null){
			return 1;
		}
		return 0;
	}

}
