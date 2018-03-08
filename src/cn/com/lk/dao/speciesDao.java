package cn.com.lk.dao;

import cn.com.lk.pojo.Page;
import cn.com.lk.pojo.Species;

public interface speciesDao extends BaseDao<Species> {

	Page<Species> searchByName(String speciesName);

	int checkByName(String name);

}
