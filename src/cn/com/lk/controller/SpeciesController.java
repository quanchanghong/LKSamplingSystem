package cn.com.lk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.com.lk.pojo.Page;
import cn.com.lk.pojo.Species;
import cn.com.lk.service.SpeciesService;

@Controller
@RequestMapping(value="/admin/species")
public class SpeciesController {
	
	@Autowired
	private SpeciesService speciesService;
	
	@RequestMapping(value="")
	public String list(Page<Species> page,Model model){
		Page<Species> onePage = speciesService.getOnePage(Species.class, page.getCurrentPage(), page.getPageSize());
		model.addAttribute("onePage", onePage);
		return "admin/species";
	}
	
	@RequestMapping(value="/delete")
	public String delete(@RequestParam String areaId){
		speciesService.deleteById(Species.class, Integer.valueOf(areaId));
		return "redirect:/admin/species";
	}

}
