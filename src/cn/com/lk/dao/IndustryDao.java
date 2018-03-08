package cn.com.lk.dao;

import cn.com.lk.pojo.Industry;
import cn.com.lk.pojo.Page;

public interface IndustryDao extends BaseDao<Industry> {

	Page<Industry> searchByName(String industryName);

	int checkByName(String speciesName);

}
