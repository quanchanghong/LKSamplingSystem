package cn.com.lk.daoImpl;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.com.lk.dao.speciesDao;
import cn.com.lk.pojo.Area;
import cn.com.lk.pojo.Page;
import cn.com.lk.pojo.Species;

@Repository("speciesDao")
public class SpeciesDaoImpl extends BaseDaoImpl<Species> implements speciesDao {

	@Override
	public Page<Species> searchByName(String speciesName) {
		Page<Species> page = new Page<Species>();
		String sql = "from Species where speciesName like '%" + speciesName + "%'";
		List<Species> list = this.getCurrentSession().createQuery(sql).list();
		
		page.setCurrentPage(1);
		page.setPageSize(50);
		page.setPageTotal(list.size());
		
		if (list != null && list.size() >0){
			page.setList(list);
		}
		return page;
	}

	@Override
	public int checkByName(String name) {
		
		return this.getCurrentSession().createQuery("from Species where speciesName='" + name + "'").list().size();
	}

}
