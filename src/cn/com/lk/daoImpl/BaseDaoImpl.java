package cn.com.lk.daoImpl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import cn.com.lk.dao.BaseDao;
import cn.com.lk.pojo.Page;

@Repository("baseDaoImpl")
public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {
	
	protected Class<T> entityClazz;
	
	public BaseDaoImpl(){
		Type type = getClass().getGenericSuperclass();
		if (type instanceof ParameterizedType){
			this.entityClazz = (Class<T>)((ParameterizedType) type).getActualTypeArguments()[0];
		}else{
			this.entityClazz = null;
		}
	}
	
	@Resource
	public void setSessionFactoryOverride(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	public Session getCurrentSession(){
		return this.getSessionFactory().getCurrentSession();
	}

	@Override
	public List<T> getAll() {
		return getCurrentSession().createQuery("from " + entityClazz.getSimpleName()).list();
	}

	@Override
	public Page<T> getOnePage(Class<T> clazz, Integer index, Integer max) {
		
		Page<T> page = new Page<T>();
		Session session = this.getCurrentSession();
		
		Criteria criteria = session.createCriteria(clazz);
		criteria.setFirstResult((index - 1) * page.getPageSize());
		criteria.setMaxResults(max);
		List<T> list = criteria.list();
		page.setList(list);
		
		Criteria criteriaCount = session.createCriteria(clazz);
		List<Long> countList = criteriaCount.setProjection(Projections.rowCount()).list();
		page.setPageTotal(countList.get(0).intValue());
		
		page.setCurrentPage(index);
		
		return page;
	}

	@Override
	public void deleteById(Class<T> clazz, Serializable id) {
		Session session =  this.getCurrentSession();
		T t = session.get(clazz, id);
		if (t != null){
			session.delete(t);
		}
		return ;
	}

}
