package cn.com.lk.daoImpl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import cn.com.lk.dao.BaseDao;
import cn.com.lk.pojo.Admin;
import cn.com.lk.pojo.Area;
import cn.com.lk.pojo.Industry;
import cn.com.lk.pojo.Page;
import cn.com.lk.pojo.ProductQuestion;
import cn.com.lk.pojo.Species;
import cn.com.lk.pojo.User;

@SuppressWarnings("unchecked")
@Repository("baseDao")
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

	@Override
	public T getById(Class<T> clazz, Serializable id) {
		return this.getCurrentSession().get(clazz, id);
	}

	@Override
	public List<T> getAllEntityByType(Class<T> claszz) {
		return this.getCurrentSession().createQuery("from " + entityClazz.getSimpleName()).list();
	}

	@Override
	public void update(T t) {
		this.getCurrentSession().update(t);
	}
	
	@Override
	public List<Species> getAllSpecies() throws Exception {
		
		return this.getCurrentSession().createQuery("from Species").list();
	}

	@Override
	public List<Area> getAllArea() throws Exception {
		// TODO Auto-generated method stub
		return this.getCurrentSession().createQuery("from Area").list();
	}

	@Override
	public List<Industry> getAllIndustry() throws Exception {
		// TODO Auto-generated method stub
		return this.getCurrentSession().createQuery("from Industry").list();
	}

	@Override
	public Map<String, Object> getAreaIndustrySpeciesMap() throws Exception {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		List<Area> areaList = this.getAllArea();
		List<Industry> industryList = this.getAllIndustry();
		List<Species> speciesList = this.getAllSpecies();
		
		map.put("areaList", areaList);
		map.put("industryList", industryList);
		map.put("speciesList", speciesList);
		
		return map;
	}

	@Override
	public Integer save(T t) {
		return (Integer) this.getCurrentSession().save(t);
	}

	@Override
	public void saveOrUpdate(T t) {
		this.getCurrentSession().saveOrUpdate(t);
	}

	@Override
	public Admin getAdminByName(String adminName) throws Exception{
		Admin admin = null;
		List<Admin> list = this.getCurrentSession().createQuery("from Admin where adminName='" + adminName +"'").list();
		if ((list != null) && (list.size() > 0)){
			admin = list.get(0);
		}
		return admin;
	}

	@Override
	public User getUserByName(String userName) throws Exception {
		User user = null;
		List<User> list = this.getCurrentSession().createQuery("from User where userName='" + userName +"'").list();
		if ((list != null) && (list.size() > 0)){
			user = list.get(0);
		}
		return user;
	}

	@Override
	public List<ProductQuestion> getAllProductQuestionList() throws Exception {
		String hql = "from ProductQuestion";
		return this.getCurrentSession().createQuery(hql).list();
	}

	@Override
	public <T> T getEntityById(Class<T> clazz, Integer id) {
		return this.getCurrentSession().get(clazz, id);
	}

	


}
