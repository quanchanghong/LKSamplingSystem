package cn.com.lk.controller;

import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.com.lk.constant.RealmConstant;
import cn.com.lk.pojo.AIS;
import cn.com.lk.pojo.Page;
import cn.com.lk.service.AisService;

@Controller
@RequestMapping(value="/admin/ais")
public class AisController {
	
	@Autowired
	private AisService aisService;
	
	@RequestMapping(value="")
	@RequiresRoles(value=RealmConstant.SYSTEM_ROLE_TYPE_ADMIN)
	public String list(Page<AIS> page,Model model){
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
	public String save(AIS ais, Model model){
		@SuppressWarnings("unused")
		Integer id = aisService.save(ais);
		return "redirect:/admin/ais";
	}
	
}
