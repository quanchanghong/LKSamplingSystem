package cn.com.lk.dao;

import cn.com.lk.pojo.AIS;
import cn.com.lk.pojo.Concentration;

public interface ConcentrationDao extends BaseDao<Concentration> {

	AIS getAISBy3Ids(Integer areaId, Integer speciesId, Integer industryId) throws Exception;

}
