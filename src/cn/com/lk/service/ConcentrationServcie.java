package cn.com.lk.service;

import cn.com.lk.pojo.Concentration;

public interface ConcentrationServcie extends BaseService<Concentration> {

	String calculate(Integer areaId, Integer speciesId, Integer industryId, Double concentration) throws Exception;

}
