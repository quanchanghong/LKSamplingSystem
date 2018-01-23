package cn.com.lk.daoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import cn.com.lk.dao.ConcentrationDao;
import cn.com.lk.pojo.AIS;
import cn.com.lk.pojo.Concentration;
import cn.com.lk.pojo.Species;

@Repository("concentrationDao")
public class ConcentrationDaoImpl extends BaseDaoImpl<Concentration> implements ConcentrationDao {

	@Override
	public AIS getAISBy3Ids(Integer areaId, Integer speciesId, Integer industryId) throws Exception {

		String hql = "from AIS where area.areaId=" + areaId + " and species.speciesId="+ speciesId + " and industry.industryId=" + industryId + "";
		List<AIS> list = this.getCurrentSession().createQuery(hql).list();
		
		AIS ais = null;
		if(list.size() > 0 && list != null){
			ais = list.get(0);
		}
		
		return ais;
	}


}
