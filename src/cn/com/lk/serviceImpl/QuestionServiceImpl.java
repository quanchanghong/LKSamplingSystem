package cn.com.lk.serviceImpl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import cn.com.lk.constant.CommonConstant;
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

	@Override
	public void saveWithMultipartFile(MultipartFile pdImgFile,MultipartHttpServletRequest multipartRequest, ProductQuestion pd) throws Exception {
		File file = new File(CommonConstant.PRODUCT_QUESTION_BASE_PATH);
		if (!file.exists()){
			file.mkdirs();
		}
		
		if (!pdImgFile.isEmpty()){
			String pdImgAbsulatePath = CommonConstant.PRODUCT_QUESTION_BASE_PATH + "\\" + pd.getType() + "-" + pdImgFile.getOriginalFilename();
			FileOutputStream fos = new FileOutputStream(pdImgAbsulatePath);
			fos.write(pdImgFile.getBytes());
			fos.flush();
			fos.close();
			
			String pdImgVisitPath = CommonConstant.VISIT_PRODUCT_QUESTION_BASE_PATH + pd.getType() + "-" + pdImgFile.getOriginalFilename();
			pd.setImgurl(pdImgVisitPath);
			
			questionDao.save(pd);
		}
	}
}
