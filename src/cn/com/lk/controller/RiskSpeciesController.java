package cn.com.lk.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
	public String showRiskSpecies(Model model) throws Exception{
		
		Map<String, Object> areaIndustrySpeciesMap = riskSpeciesService.getAreaIndustrySpeciesMap();
		model.addAttribute("areaIndustrySpeciesMap", areaIndustrySpeciesMap);
		
		return "admin/riskSpecies";
	}

}
