package cn.com.lk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.com.lk.pojo.Industry;
import cn.com.lk.pojo.Page;
import cn.com.lk.service.IndustryService;

@Controller
@RequestMapping(value="/admin/industry")
public class IndustryController {
	
	@Autowired
	private IndustryService industryService;
	
	@RequestMapping(value="")
	public String list(Page<Industry> page,Model model){
		Page<Industry> onePage = industryService.getOnePage(Industry.class, page.getCurrentPage(), page.getPageSize());
		model.addAttribute("onePage", onePage);
		return "admin/industry";
	}
	
	@RequestMapping(value="/delete")
	public String delete(@RequestParam String industryId){
		industryService.deleteById(Industry.class, Integer.valueOf(industryId));
		return "redirect:/admin/industry";
	}

}
