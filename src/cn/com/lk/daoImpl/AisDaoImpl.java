package cn.com.lk.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import cn.com.lk.dao.AisDao;
import cn.com.lk.pojo.AIS;
import cn.com.lk.pojo.Page;

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

	@Override
	public Page<AIS> searchByName(String speciesName) {
		
		Page<AIS> page = new Page<AIS>();
		String sql = "from AIS where species.speciesName like '%" + speciesName + "%' or name like '%" + speciesName + "%'";
		List<AIS> list = this.getCurrentSession().createQuery(sql).list();
		
		page.setCurrentPage(1);
		page.setPageSize(50);
		page.setPageTotal(list.size());
		
		if (list != null && list.size() >0){
			page.setList(list);
		}
		return page;
	}

}
