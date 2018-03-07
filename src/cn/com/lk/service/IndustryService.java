package cn.com.lk.service;

import cn.com.lk.pojo.Industry;
import cn.com.lk.pojo.Page;

public interface IndustryService extends BaseService<Industry> {

	Page<Industry> searchByName(String industryName) throws Exception;

}
