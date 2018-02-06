package cn.com.lk.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import cn.com.lk.constant.PageConstant;
import cn.com.lk.pojo.Page;
import cn.com.lk.pojo.ProductQuestion;
import cn.com.lk.service.QuestionService;

@Controller
@RequestMapping("/admin/question")
public class QuestionController {
	
	@Autowired
	@Qualifier("questionService")
	private QuestionService questionService;
	
	@RequestMapping("")
	public String showQuestions(Page<ProductQuestion> page, Model model){
		Page<ProductQuestion> questionPage = questionService.getOnePage(ProductQuestion.class, page.getCurrentPage(), PageConstant.ONE_PAGE_SIZE);
		model.addAttribute("questionPage", questionPage);
		
		return "admin/productQuestions";
	}
	
	@RequestMapping("/add")
	public String showAddQuestion(Model model){
		return "admin/productQuestionAdd";
	}
	
	@RequestMapping("/save")
	public String saveWithMultipartFile(@RequestParam("questionImg") MultipartFile pdImgFile, HttpServletRequest request, ProductQuestion pd, Model model) throws Exception{
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		questionService.saveWithMultipartFile(pdImgFile, multipartRequest, pd);
		return "redirect:/admin/question";
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam String pdId, Model model){
		questionService.deleteById(ProductQuestion.class, Integer.parseInt(pdId));
		return "redirect:/admin/question";
	}

}
