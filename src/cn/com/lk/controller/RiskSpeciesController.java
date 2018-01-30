package cn.com.lk.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import cn.com.lk.constant.PageConstant;
import cn.com.lk.pojo.BaseSpecies;
import cn.com.lk.pojo.Page;
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
	
	
	@RequestMapping("/add")
	public String addRiskSpecies(Model model) throws Exception{
		
		Map<String, Object> areaIndustrySpeciesMap = riskSpeciesService.getAreaIndustrySpeciesMap();
		model.addAttribute("areaIndustrySpeciesMap", areaIndustrySpeciesMap);
		
		return "admin/riskSpecies";
	}
	
	@ResponseBody
	@RequestMapping("/save")
	public String saveData(@RequestParam String jsonStr) throws Exception{
		List<BaseSpecies> baseSpeciesList = JSON.parseArray(jsonStr, BaseSpecies.class);
		Integer i = riskSpeciesService.saveObjecList(baseSpeciesList);
		return i.toString();
	}

}
