package cn.com.lk.daoImpl;

import org.springframework.stereotype.Repository;

import cn.com.lk.dao.RiskDao;
import cn.com.lk.pojo.ProductQuestion;

@Repository("riskDao")
public class RiskDaoImpl extends BaseDaoImpl<ProductQuestion> implements RiskDao {

}
