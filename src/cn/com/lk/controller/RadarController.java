package cn.com.lk.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.com.lk.service.AreaService;
import cn.com.lk.service.BaseService;
import cn.com.lk.service.IndustryService;
import cn.com.lk.service.SpeciesService;

@Controller
@RequestMapping(value="/radar")
public class RadarController {
	
	@Autowired
	private BaseService baseService;
	/*@Autowired
	private IndustryService industryService;
	@Autowired
	private SpeciesService speciesService;*/
	
	@RequestMapping(value="")
	public String showRadar(Model model) throws Exception{
		Map areaIndustrySpeciesMap = baseService.getAreaIndustrySpeciesMap();
		model.addAttribute("areaIndustrySpeciesMap", areaIndustrySpeciesMap);
		return "user/radar_new";
	}

}
