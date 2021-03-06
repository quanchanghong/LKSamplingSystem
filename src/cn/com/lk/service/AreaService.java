package cn.com.lk.service;

import java.util.List;

import cn.com.lk.pojo.AIS;
import cn.com.lk.pojo.Area;
import cn.com.lk.pojo.Page;

public interface AreaService extends BaseService<Area>{

	List<Area> getAll();

	Page<Area> searchByName(String areaName) throws Exception;
	
	int checkByName(String name);

	//Page<Area> getOneAreaPage(Class<Area> class1, int i, int j);

	//void deleteAreaById(Class<Area> class1, Integer valueOf);

}
