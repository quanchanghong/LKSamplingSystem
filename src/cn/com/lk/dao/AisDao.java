package cn.com.lk.dao;

import cn.com.lk.pojo.AIS;
import cn.com.lk.pojo.Page;

public interface AisDao extends BaseDao<AIS> {

	Integer queryAisBeforeSave(AIS ais);

	Page<AIS> searchByName(String speciesName);

}
