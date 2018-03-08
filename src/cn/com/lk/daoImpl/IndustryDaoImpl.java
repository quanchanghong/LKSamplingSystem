package cn.com.lk.daoImpl;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.com.lk.dao.IndustryDao;
import cn.com.lk.pojo.Area;
import cn.com.lk.pojo.Industry;
import cn.com.lk.pojo.Page;

@Repository("industryDao")
public class IndustryDaoImpl extends BaseDaoImpl<Industry> implements IndustryDao {

	@Override
	public Page<Industry> searchByName(String industryName) {
		Page<Industry> page = new Page<Industry>();
		String sql = "from Industry where industryName like '%" + industryName + "%'";
		List<Industry> list = this.getCurrentSession().createQuery(sql).list();
		
		page.setCurrentPage(1);
		page.setPageSize(50);
		page.setPageTotal(list.size());
		
		if (list != null && list.size() >0){
			page.setList(list);
		}
		return page;
	}

	@Override
	public int checkByName(String industryName) {
		
		return this.getCurrentSession().createQuery("from Industry where industryName='" + industryName + "'").list().size();
	}


}
