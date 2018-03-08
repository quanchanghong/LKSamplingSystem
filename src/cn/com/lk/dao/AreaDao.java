package cn.com.lk.dao;

import cn.com.lk.pojo.Area;
import cn.com.lk.pojo.Page;

public interface AreaDao extends BaseDao<Area> {

	Page<Area> searchByName(String areaName);
	
	int checkByName(String name);

}
