package cn.com.lk.service;

import cn.com.lk.pojo.ProductQuestion;

public interface RiskService extends BaseService<ProductQuestion>{

	String getRiskResult(int pdId, double riskValue) throws Exception;

}
