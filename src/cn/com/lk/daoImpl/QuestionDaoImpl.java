package cn.com.lk.daoImpl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.com.lk.dao.QuestionDao;
import cn.com.lk.pojo.Admin;
import cn.com.lk.pojo.Area;
import cn.com.lk.pojo.Industry;
import cn.com.lk.pojo.Page;
import cn.com.lk.pojo.ProductQuestion;
import cn.com.lk.pojo.Species;
import cn.com.lk.pojo.User;

@Repository("questionDao")
public class QuestionDaoImpl extends BaseDaoImpl<ProductQuestion> implements QuestionDao {


}
