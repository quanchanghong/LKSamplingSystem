package cn.com.lk.serviceImpl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.lk.dao.QuestionDao;
import cn.com.lk.pojo.Admin;
import cn.com.lk.pojo.Area;
import cn.com.lk.pojo.Industry;
import cn.com.lk.pojo.Page;
import cn.com.lk.pojo.ProductQuestion;
import cn.com.lk.pojo.Species;
import cn.com.lk.pojo.User;
import cn.com.lk.service.QuestionService;

@Transactional
@Service("questionService")
public class QuestionServiceImpl extends BaseServiceImpl<ProductQuestion> implements QuestionService {

	@Autowired
	@Qualifier("questionDao")
	private QuestionDao questionDao;

}
