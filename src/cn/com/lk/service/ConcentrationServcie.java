package cn.com.lk.service;

import cn.com.lk.pojo.AIS;

public interface ConcentrationServcie extends BaseService<AIS> {

	Double calculate(Integer areaId, Integer speciesId, Integer industryId, Double concentration) throws Exception;

}
