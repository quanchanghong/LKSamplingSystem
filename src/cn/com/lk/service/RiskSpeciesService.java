package cn.com.lk.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import cn.com.lk.pojo.AISCP;
import cn.com.lk.pojo.BaseSpecies;
import cn.com.lk.pojo.ProductQuestion;

public interface RiskSpeciesService extends BaseService<BaseSpecies> {

	Integer SaveCustomSpeciesWithRisk(ProductQuestion pd, BaseSpecies baseSpecies, List<AISCP> aISCPList) throws Exception;

	void deleteBaseSpecies(int parseInt) throws Exception;

}
