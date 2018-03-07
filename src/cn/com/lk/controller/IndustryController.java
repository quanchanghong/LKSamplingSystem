package cn.com.lk.controller;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.com.lk.constant.RealmConstant;
import cn.com.lk.pojo.Area;
import cn.com.lk.pojo.Industry;
import cn.com.lk.pojo.Page;
import cn.com.lk.service.IndustryService;

@Controller
@RequestMapping(value="/admin/industry")
public class IndustryController {
	
	@Autowired
	private IndustryService industryService;
	
	@RequestMapping(value="")
	@RequiresRoles(value=RealmConstant.SYSTEM_ROLE_TYPE_ADMIN)
	public String list(Page<Industry> page,Model model){
		Page<Industry> onePage = industryService.getOnePage(Industry.class, page.getCurrentPage(), page.getPageSize());
		model.addAttribute("onePage", onePage);
		return "admin/industry";
	}
	
	@RequestMapping(value="/search")
	public String search(@RequestParam String industryName, Model model) throws Exception{
		Page<Industry> onePage = industryService.searchByName(industryName);
		model.addAttribute("onePage", onePage);
		return "admin/industry";
	}
	
	@RequestMapping(value="/delete")
	public String delete(@RequestParam String industryId){
		industryService.deleteById(Industry.class, Integer.valueOf(industryId));
		return "redirect:/admin/industry";
	}
	
	@RequestMapping(value="/add")
	public String add(Model model){
		return "admin/industryEdit";
	}
	
	@RequestMapping(value="/save")
	public String save(Industry industry){
		industryService.saveOrUpdate(industry);
		return "redirect:/admin/industry";
	}
	
	@RequestMapping(value="/edit")
	public String edit(@RequestParam String industryId, Model model){
		Industry industry = industryService.getById(Industry.class, Integer.parseInt(industryId));
		model.addAttribute("industry", industry);
		return "admin/industryEdit";
	}

}
