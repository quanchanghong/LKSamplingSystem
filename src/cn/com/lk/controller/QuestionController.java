package cn.com.lk.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import cn.com.lk.pojo.ProductQuestion;
import cn.com.lk.service.QuestionService;

@Controller
@RequestMapping("/admin/question")
public class QuestionController {
	
	@Autowired
	@Qualifier("questionService")
	private QuestionService questionService;
	
	@RequestMapping("/save")
	public String saveWithMultipartFile(HttpServletRequest request, ProductQuestion pd, Model model){
		
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		System.out.println(pd);
		//Integer success = questionService.saveWithMultipartFile();
		return null;
	}

}
