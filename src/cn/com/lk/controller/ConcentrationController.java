package cn.com.lk.controller;

import java.util.Map;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.com.lk.service.ConcentrationServcie;
import cn.com.lk.utils.EhcacheUtils;

/**
 * ≈®∂»≈≈√˚
 * @author 1500000367-3
 *
 */
@Controller
@RequestMapping("/concentration")
public class ConcentrationController {
	
	@Autowired
	private ConcentrationServcie concentrationServcie;
	
	@RequestMapping("")
	public String showConcentration(Model model) throws Exception{
		
		Map<String, Object> map = concentrationServcie.getAreaIndustrySpeciesMap();
			
		model.addAttribute("aisMap", map);
		
		return "user/concentration";
	}

}
