package cn.com.lk.dao;

import cn.com.lk.pojo.Page;
import cn.com.lk.pojo.ProductQuestion;

public interface QuestionDao extends BaseDao<ProductQuestion> {

	Page<ProductQuestion> searchByName(String questionName);

	int checkByName(String name);

}
