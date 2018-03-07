package cn.com.lk.daoImpl;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.com.lk.dao.AreaDao;
import cn.com.lk.pojo.AIS;
import cn.com.lk.pojo.Area;
import cn.com.lk.pojo.Page;

@Repository
public class AreaDaoImpl extends BaseDaoImpl<Area> implements AreaDao {

	@Override
	public Page<Area> searchByName(String areaName) {
		Page<Area> page = new Page<Area>();
		String sql = "from Area where areaName like '%" + areaName + "%'";
		List<Area> list = this.getCurrentSession().createQuery(sql).list();
		
		page.setCurrentPage(1);
		page.setPageSize(50);
		page.setPageTotal(list.size());
		
		if (list != null && list.size() >0){
			page.setList(list);
		}
		return page;
	}
	
}
