package cn.com.lk.daoImpl;

import org.springframework.stereotype.Repository;

import cn.com.lk.dao.IndustryDao;
import cn.com.lk.pojo.Industry;

@Repository("industryDao")
public class IndustryDaoImpl extends BaseDaoImpl<Industry> implements IndustryDao {


}
