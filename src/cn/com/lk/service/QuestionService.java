package cn.com.lk.service;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import cn.com.lk.pojo.Page;
import cn.com.lk.pojo.ProductQuestion;

public interface QuestionService extends BaseService<ProductQuestion> {

	void saveWithMultipartFile(MultipartFile pdImgFile,MultipartHttpServletRequest multipartRequest, ProductQuestion pd) throws Exception;

	Page<ProductQuestion> searchByName(String questionName) throws Exception;
	
	int checkByName(String name);

}
