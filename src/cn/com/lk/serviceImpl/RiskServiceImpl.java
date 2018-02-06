package cn.com.lk.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.lk.dao.RiskDao;
import cn.com.lk.pojo.ProductQuestion;
import cn.com.lk.service.RiskService;

@Transactional
@Service("riskService")
public class RiskServiceImpl extends BaseServiceImpl<ProductQuestion> implements RiskService {
	
	@Autowired
	@Qualifier("riskDao")
	private RiskDao riskDao;

}
