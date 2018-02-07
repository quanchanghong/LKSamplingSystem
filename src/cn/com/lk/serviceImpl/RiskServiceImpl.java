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

	@Override
	public String getRiskResult(int pdId, double riskValue) throws Exception {
		
		String msg = "查询失败！";
		
		ProductQuestion pd = riskDao.getById(ProductQuestion.class, pdId);
		if (pd.getMin() > riskValue){
			msg = "恭喜!你的风险值小于过去经验的参考值。";
		}
		else if ((riskValue >= pd.getMin()) && (riskValue <= pd.getMax())){
			msg = "你的风险值处于过去经验参考值范围之内。";
		}
		else{
			msg = "你的风险值已经大于过去经验的参考值，发生概率很大!";
		}
		
		return msg;
	}

}
