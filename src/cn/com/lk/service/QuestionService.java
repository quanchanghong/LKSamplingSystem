package cn.com.lk.service;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import cn.com.lk.pojo.ProductQuestion;

public interface QuestionService extends BaseService<ProductQuestion> {

	void saveWithMultipartFile(MultipartFile pdImgFile,MultipartHttpServletRequest multipartRequest, ProductQuestion pd) throws Exception;

}
