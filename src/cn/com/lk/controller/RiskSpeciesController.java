package cn.com.lk.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.sun.org.apache.xpath.internal.operations.Mod;

import cn.com.lk.constant.ConcentrationConstant;
import cn.com.lk.constant.PageConstant;
import cn.com.lk.pojo.AISCP;
import cn.com.lk.pojo.Area;
import cn.com.lk.pojo.BaseSpecies;
import cn.com.lk.pojo.Page;
import cn.com.lk.pojo.ProductQuestion;
import cn.com.lk.service.RiskSpeciesService;
/**
 * 计算风险值相关的物种
 * @author 1500000367-3
 *
 */
@RequestMapping("/admin/riskSpecies")
@Controller
public class RiskSpeciesController {
	
	@Autowired
	@Qualifier("riskSpeciesService")
	private RiskSpeciesService riskSpeciesService;
	
	@RequestMapping("")
	public String showRiskSpecies(Page<BaseSpecies> page, Model model) throws Exception{
		
		Page<BaseSpecies> baseSpeciesPage = riskSpeciesService.getOnePage(BaseSpecies.class, page.getCurrentPage(), PageConstant.ONE_PAGE_SIZE);
		model.addAttribute("baseSpeciesPage", baseSpeciesPage);
		return "admin/baseSpecies";
	}
	
	@RequestMapping(value="/search")
	public String search(@RequestParam String baseSpeciesName, Model model) throws Exception{
		Page<BaseSpecies> baseSpeciesPage = riskSpeciesService.searchByName(baseSpeciesName);
		model.addAttribute("baseSpeciesPage", baseSpeciesPage);
		return "admin/baseSpecies";
	}
	
	@RequestMapping("/look")
	public String showRiskSpeciesDetail(@RequestParam String id, Model model){
		BaseSpecies baseSpecies = riskSpeciesService.getById(BaseSpecies.class, Integer.parseInt(id));
		model.addAttribute("baseSpecies", baseSpecies);
		return "admin/baseSpeciesDetail";
	}
	
	@RequestMapping("/add")
	public String addRiskSpecies(Model model) throws Exception{
		
		Map<String, Object> areaIndustrySpeciesMap = riskSpeciesService.getAreaIndustrySpeciesMap();
		List<ProductQuestion> productQuestionList = riskSpeciesService.getAllProductQuestionList();
		model.addAttribute("areaIndustrySpeciesMap", areaIndustrySpeciesMap);
		model.addAttribute("productQuestionList", productQuestionList);
		return "admin/baseSpeciesAdd";
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam String id, Model model) throws Exception{
		riskSpeciesService.deleteBaseSpecies(Integer.parseInt(id));
		//riskSpeciesService.deleteById(BaseSpecies.class, Integer.parseInt(id));
		return "redirect:/admin/riskSpecies";
	}
	//public String saveData(@RequestParam String pdType,BaseSpecies baseSpecies,@RequestParam String jsonStr, Model model, HttpServletRequest request) throws Exception{
	@ResponseBody
	@RequestMapping("/save")
	public String saveData(ProductQuestion pd,BaseSpecies baseSpecies,@RequestParam String jsonStr, Model model, HttpServletRequest request) throws Exception{
		
		List<AISCP> AISCPList = JSON.parseArray(jsonStr, AISCP.class);
		Integer isSuucess = riskSpeciesService.SaveCustomSpeciesWithRisk(pd,baseSpecies, AISCPList);
		return isSuucess.toString();
	}
	
	@RequestMapping("/questionAdd")
	public String questionDataAdd(Model model){
		
		return "admin/productQuestionAdd";
	}

}
