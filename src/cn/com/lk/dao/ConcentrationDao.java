package cn.com.lk.dao;

import java.util.List;

import cn.com.lk.pojo.AIS;
import cn.com.lk.pojo.Concentration;
import cn.com.lk.pojo.Species;

public interface ConcentrationDao extends BaseDao<Concentration> {

	AIS getAISBy3Ids(Integer areaId, Integer speciesId, Integer industryId) throws Exception;

	List<Species> initRadarRandSpecies(Integer initRadarRandSpeciesCount) throws Exception;

}
