package cn.com.lk.service;

import cn.com.lk.pojo.Page;
import cn.com.lk.pojo.Species;

public interface SpeciesService extends BaseService<Species> {

	Page<Species> searchByName(String speciesName) throws Exception;
	
	int checkByName(String name);

}
