package cn.com.lk.dao;

import java.util.List;

import cn.com.lk.pojo.BaseSpecies;

public interface RiskSpeciesDao extends BaseDao<BaseSpecies> {

	Integer saveObjecList(List<BaseSpecies> baseSpeciesList) throws Exception;

}
