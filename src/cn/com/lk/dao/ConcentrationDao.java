package cn.com.lk.dao;

import cn.com.lk.pojo.AIS;

public interface ConcentrationDao extends BaseDao<AIS> {

	AIS getAISBy3Ids(Integer areaId, Integer speciesId, Integer industryId) throws Exception;

}
