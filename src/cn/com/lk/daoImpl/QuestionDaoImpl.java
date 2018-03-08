package cn.com.lk.daoImpl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.com.lk.dao.QuestionDao;
import cn.com.lk.pojo.Admin;
import cn.com.lk.pojo.Area;
import cn.com.lk.pojo.Industry;
import cn.com.lk.pojo.Page;
import cn.com.lk.pojo.ProductQuestion;
import cn.com.lk.pojo.Species;
import cn.com.lk.pojo.User;

@Repository("questionDao")
public class QuestionDaoImpl extends BaseDaoImpl<ProductQuestion> implements QuestionDao {

	@Override
	public Page<ProductQuestion> searchByName(String questionName) {
		Page<ProductQuestion> page = new Page<ProductQuestion>();
		String sql = "from ProductQuestion where type like '%" + questionName + "%'";
		List<ProductQuestion> list = this.getCurrentSession().createQuery(sql).list();
		
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
		
		return this.getCurrentSession().createQuery("from ProductQuestion where type='" + name + "'").list().size();
	}


}
