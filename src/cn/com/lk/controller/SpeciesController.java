package cn.com.lk.controller;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.lk.constant.RealmConstant;
import cn.com.lk.pojo.Area;
import cn.com.lk.pojo.Page;
import cn.com.lk.pojo.Species;
import cn.com.lk.service.SpeciesService;

@Controller
@RequestMapping(value="/admin/species")
public class SpeciesController {
	
	@Autowired
	private SpeciesService speciesService;
	
	@RequestMapping(value="")
	@RequiresRoles(value=RealmConstant.SYSTEM_ROLE_TYPE_ADMIN)
	public String list(Page<Species> page,Model model){
		Page<Species> onePage = speciesService.getOnePage(Species.class, page.getCurrentPage(), page.getPageSize());
		model.addAttribute("onePage", onePage);
		return "admin/species";
	}
	
	@RequestMapping(value="/search")
	public String search(@RequestParam String speciesName, Model model) throws Exception{
		Page<Species> onePage = speciesService.searchByName(speciesName);
		model.addAttribute("onePage", onePage);
		return "admin/species";
	}
	
	@ResponseBody
	@RequestMapping(value="/checkBeforeSave")
	public String checkBeforeSave(@RequestParam String speciesName) throws Exception{
		
		return String.valueOf(speciesService.checkByName(speciesName));
	}
	
	@RequestMapping(value="/delete")
	public String delete(@RequestParam String speciesId){
		speciesService.deleteById(Species.class, Integer.valueOf(speciesId));
		return "redirect:/admin/species";
	}
	
	@RequestMapping(value="/add")
	public String add(Model model){
		return "admin/speciesEdit";
	}
	
	@RequestMapping(value="/save")
	public String save(Species species){
		speciesService.saveOrUpdate(species);
		return "redirect:/admin/species";
	}
	
	@RequestMapping(value="/edit")
	public String edit(@RequestParam String speciesId, Model model){
		Species species = speciesService.getById(Species.class, Integer.parseInt(speciesId));
		model.addAttribute("species", species);
		return "admin/speciesEdit";
	}

}
