package cn.com.lk.controller;

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
import cn.com.lk.service.AreaService;

@Controller
@RequestMapping(value="/admin/area")
public class AreaController {
	
	@Autowired
	private AreaService areaService;
	
	@RequestMapping(value="")
	@RequiresRoles(value=RealmConstant.SYSTEM_ROLE_TYPE_ADMIN)
	public String list(Page<Area> page,Model model){
		Page<Area> onePage = areaService.getOnePage(Area.class, page.getCurrentPage(), page.getPageSize());
		model.addAttribute("onePage", onePage);
		return "admin/area";
	}
	
	@RequestMapping(value="/search")
	public String search(@RequestParam String areaName, Model model) throws Exception{
		Page<Area> onePage = areaService.searchByName(areaName);
		model.addAttribute("onePage", onePage);
		return "admin/area";
	}
	
	@ResponseBody
	@RequestMapping(value="/checkBeforeSave")
	public String checkBeforeSave(@RequestParam String areaName) throws Exception{
		
		return String.valueOf(areaService.checkByName(areaName));
	}
	
	@RequestMapping(value="/delete")
	public String delete(@RequestParam String areaId){
		areaService.deleteById(Area.class, Integer.valueOf(areaId));
		return "redirect:/admin/area";
	}
	
	@RequestMapping(value="/add")
	public String add(Model model){
		return "admin/areaEdit";
	}
	
	@RequestMapping(value="/save")
	public String save(Area area){
		areaService.saveOrUpdate(area);
		return "redirect:/admin/area";
	}
	
	@RequestMapping(value="/edit")
	public String edit(@RequestParam String areaId, Model model){
		Area area = areaService.getById(Area.class, Integer.parseInt(areaId));
		model.addAttribute("area", area);
		return "admin/areaEdit";
	}

}
