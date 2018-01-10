package cn.com.lk.daoImpl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import cn.com.lk.dao.AdminDao;
import cn.com.lk.pojo.Admin;

@Repository
public class AdminDaoImpl extends HibernateDaoSupport implements AdminDao {
	
	@Resource
	public void setSessionFactoryOverride(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Override
	public Admin login(Integer adminId) {
		Session session = this.getSessionFactory().getCurrentSession();
		List<Admin> list = session.createQuery("from Admin where adminId=" + adminId + "").list();
		return list.get(0);
	}

}
