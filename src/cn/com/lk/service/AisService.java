package cn.com.lk.service;

import java.util.Map;

import cn.com.lk.pojo.AIS;
import cn.com.lk.pojo.Page;

public interface AisService extends BaseService<AIS> {

	Map<String, Object> getAisEditMap(Integer id) throws Exception;

	Integer queryAisBeforeSave(AIS ais) throws Exception;

	Page<AIS> searchByName(String speciesName) throws Exception;

}
