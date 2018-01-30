package cn.com.lk.service;

import java.util.List;

import cn.com.lk.pojo.BaseSpecies;

public interface RiskSpeciesService extends BaseService<BaseSpecies> {

	Integer saveObjecList(List<BaseSpecies> baseSpeciesList) throws Exception;

}
