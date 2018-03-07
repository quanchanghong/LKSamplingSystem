package cn.com.lk.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.lk.constant.RealmConstant;
import cn.com.lk.pojo.AIS;
import cn.com.lk.pojo.Area;
import cn.com.lk.pojo.Industry;
import cn.com.lk.pojo.Page;
import cn.com.lk.pojo.Species;
import cn.com.lk.service.AisService;
import cn.com.lk.utils.RoleUtils;

@Controller
@RequestMapping(value="/admin/ais")
public class AisController {
	
	@Autowired
	private AisService aisService;
	
	@RequestMapping(value="")
	@RequiresRoles(value=RealmConstant.SYSTEM_ROLE_TYPE_ADMIN)
	public String list(Page<AIS> page,Model model, HttpServletRequest request){
		
		//request.getSession().removeAttribute("msgcode");
		
		Page<AIS> onePage = aisService.getOnePage(AIS.class, page.getCurrentPage(), page.getPageSize());
		model.addAttribute("onePage", onePage);
		return "admin/ais";
	}
	
	@RequestMapping(value="/delete")
	public String delete(@RequestParam String id){
		aisService.deleteById(AIS.class, Integer.valueOf(id));
		return "redirect:/admin/ais";
	}
	
	@RequestMapping(value="/edit")
	public String edit(@RequestParam String id, Model model) throws Exception{
		Map<String, Object> editMap = aisService.getAisEditMap(Integer.parseInt(id));
		model.addAttribute("editMap", editMap);
		return "admin/aisEdit";
	}
	
	@RequestMapping(value="/update")
	public String update(AIS ais){
		aisService.update(ais);
		return "redirect:/admin/ais";
	}
	
	@RequestMapping(value="/add")
	public String add(Model model) throws Exception{
		Map<String, Object> addMap = aisService.getAreaIndustrySpeciesMap();
		model.addAttribute("addMap", addMap);
		return "admin/aisAdd";
	}
	
	@RequestMapping(value="/save")
	public String save(AIS ais, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception{
		aisService.save(ais);
		return "redirect:/admin/ais";
	}
	
	@RequestMapping(value="/search")
	public String search(@RequestParam String speciesName, Model model) throws Exception{
		Page<AIS> onePage = aisService.searchByName(speciesName);
		model.addAttribute("onePage", onePage);
		return "admin/ais";
	}
	
	@ResponseBody
	@RequestMapping(value="/checkBeforeSave")
	public String checkBeforeSave(@RequestParam String areaId, @RequestParam String industryId, @RequestParam String speciesId) throws Exception{
		
		AIS ais = new AIS();
		
		Industry industry = new Industry();
		industry.setIndustryId(Integer.parseInt(industryId));
		Area area = new Area();
		area.setAreaId(Integer.parseInt(areaId));
		Species species = new Species();
		species.setSpeciesId(Integer.parseInt(speciesId));
		
		ais.setArea(area);
		ais.setIndustry(industry);
		ais.setSpecies(species);
		
		Integer isExist = aisService.queryAisBeforeSave(ais);
		
		return isExist.toString();
	}
	
}
