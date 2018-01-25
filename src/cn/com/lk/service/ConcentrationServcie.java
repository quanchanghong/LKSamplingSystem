package cn.com.lk.service;

import cn.com.lk.pojo.Concentration;
import cn.com.lk.pojo.Radar;

public interface ConcentrationServcie extends BaseService<Concentration> {

	String calculate(Integer areaId, Integer speciesId, Integer industryId, Double concentration) throws Exception;

	String calculateRadarRisk(Radar radar) throws Exception;

}
