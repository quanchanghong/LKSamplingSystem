package cn.com.lk.serviceImpl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.lk.constant.ConcentrationConstant;
import cn.com.lk.dao.QuestionDao;
import cn.com.lk.dao.RiskSpeciesDao;
import cn.com.lk.pojo.AISCP;
import cn.com.lk.pojo.BaseSpecies;
import cn.com.lk.pojo.ProductQuestion;
import cn.com.lk.service.RiskSpeciesService;
import cn.com.lk.utils.ConcentrationUtils;

@Transactional
@Service("riskSpeciesService")
public class RiskSpeciesServiceImpl extends BaseServiceImpl<BaseSpecies> implements RiskSpeciesService {

	@Autowired
	@Qualifier("riskSpeciesDao")
	private RiskSpeciesDao riskSpeciesDao;

	@Override
	public Integer SaveCustomSpeciesWithRisk(ProductQuestion pd, BaseSpecies baseSpecies, List<AISCP> aISCPList) throws Exception {
		Set<AISCP> aiscpSet = new HashSet<AISCP>(aISCPList);
		baseSpecies.setAISCPSet(aiscpSet);
		
		List<Double> percentList = new ArrayList<Double>();
		for (AISCP aiscp : aISCPList) {
			try{
				double perc = Double.parseDouble(aiscp.getPercent());
				percentList.add(perc);
			}catch(NumberFormatException numberFormatException){
				System.out.println("发生异常:浓度排名异常查询失败为字符串，转为double失败！" + this.getClass().getName());
				numberFormatException.printStackTrace();
				continue;
			}
		}
		
		double riskValue = ConcentrationUtils.calculateRiskValue(percentList);
		if (riskValue == ConcentrationConstant.CALCULATE_RISK_VALUE_ERROR){
			return ConcentrationConstant.CALCULATE_RISK_VALUE_ERROR;
		}
		
		baseSpecies.setRiskValue(riskValue);
		
		ProductQuestion productQuestion = riskSpeciesDao.getEntityById(ProductQuestion.class, pd.getPdId());
		if (riskValue > productQuestion.getMax()){
			productQuestion.setMax(riskValue);
		}
		if ((riskValue < productQuestion.getMin()) || (productQuestion.getMin() == 0d)){
			productQuestion.setMin(riskValue);
		}
		
		double totalRisk = riskValue;
		for (BaseSpecies bs : productQuestion.getBaseSpeciesSet()) {
			totalRisk += bs.getRiskValue();
		}
		productQuestion.setAvg(totalRisk/(productQuestion.getBaseSpeciesSet().size() + 1));
		
		productQuestion.setStd((productQuestion.getMax() - productQuestion.getMin()));
		
		baseSpecies.setProductQuestion(productQuestion);
		
		riskSpeciesDao.save(baseSpecies);
		
		return ConcentrationConstant.MSG_TYPE_SUCCESS;
	}

	/**
	 * 方法实现由问题，后续有需求再考虑
	 */
	@Override
	public void deleteBaseSpecies(int id) throws Exception {
		BaseSpecies baseSpecies = riskSpeciesDao.getEntityById(BaseSpecies.class, id);
		baseSpecies.getAISCPSet().remove(baseSpecies.getAISCPSet());
	
		baseSpecies.setAISCPSet(null);
		riskSpeciesDao.save(baseSpecies);
		riskSpeciesDao.deleteById(BaseSpecies.class, id);
	}

}
