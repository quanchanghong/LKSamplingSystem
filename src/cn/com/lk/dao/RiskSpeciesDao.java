package cn.com.lk.dao;

import java.util.List;

import cn.com.lk.pojo.BaseSpecies;
import cn.com.lk.pojo.Page;

public interface RiskSpeciesDao extends BaseDao<BaseSpecies> {

	Integer saveObjecList(List<BaseSpecies> baseSpeciesList) throws Exception;

	Page<BaseSpecies> searchByName(String baseSpeciesName);

}
