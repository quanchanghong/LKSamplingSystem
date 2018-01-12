package cn.com.lk.daoImpl;

import org.springframework.stereotype.Repository;

import cn.com.lk.dao.AisDao;
import cn.com.lk.pojo.AIS;

@Repository("aisDao")
public class AisDaoImpl extends BaseDaoImpl<AIS> implements AisDao {

}
