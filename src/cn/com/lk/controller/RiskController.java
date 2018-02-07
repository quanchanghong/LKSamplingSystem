package cn.com.lk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import cn.com.lk.pojo.ProductQuestion;
import cn.com.lk.service.RiskService;
/**
 * 前台风险值计算
 * @author 1500000367-3
 *
 */
@Controller
@RequestMapping("/risk")
public class RiskController {
	
	@Autowired
	@Qualifier("riskService")
	private RiskService riskService; 
	
	@RequestMapping("")
	public String showRisk(Model model) throws Exception{
		List<ProductQuestion> productQuestionList = riskService.getAllProductQuestionList();
		model.addAttribute("productQuestionList", productQuestionList);
		return "user/risk";
	}
	
	@ResponseBody
	@RequestMapping(value="/onepd", produces="application/json;charset=utf-8")
	public String getOneProductQuestion(@RequestParam String pdId){
		ProductQuestion pd = riskService.getById(ProductQuestion.class, Integer.parseInt(pdId));
		pd.setAvg(0d);
		pd.setStd(0d);
		pd.setMax(0d);
		pd.setMin(0d);
		return JSON.toJSONString(pd);
	}
	
	@ResponseBody
	@RequestMapping(value="/riskResult", produces="application/text;charset=utf-8")
	public String getRiskResult(@RequestParam String pdId, @RequestParam String riskValue) throws Exception{
		String msg = riskService.getRiskResult(Integer.parseInt(pdId), Double.parseDouble(riskValue));
		System.out.println(msg);
		return msg;
	}

}
