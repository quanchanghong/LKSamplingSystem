package cn.com.lk.service;

import java.util.List;

import cn.com.lk.pojo.Area;

public interface AreaService extends BaseService<Area>{

	List<Area> getAll();

	//Page<Area> getOneAreaPage(Class<Area> class1, int i, int j);

	//void deleteAreaById(Class<Area> class1, Integer valueOf);

}
