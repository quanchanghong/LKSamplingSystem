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
		
		String msg = "��ѯʧ�ܣ�";
		
		ProductQuestion pd = riskDao.getById(ProductQuestion.class, pdId);
		if (pd.getMin() > riskValue){
			msg = "��ϲ!��ķ���ֵС�ڹ�ȥ����Ĳο�ֵ��";
		}
		else if ((riskValue >= pd.getMin()) && (riskValue <= pd.getMax())){
			msg = "��ķ���ֵ���ڹ�ȥ����ο�ֵ��Χ֮�ڡ�";
		}
		else{
			msg = "��ķ���ֵ�Ѿ����ڹ�ȥ����Ĳο�ֵ���������ʺܴ�!";
		}
		
		return msg;
	}

}
