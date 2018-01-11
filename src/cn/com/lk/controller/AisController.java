package cn.com.lk.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.com.lk.pojo.AIS;
import cn.com.lk.pojo.Page;
import cn.com.lk.service.AisService;

@Controller
@RequestMapping(value="/admin/ais")
public class AisController {
	
	@Autowired
	private AisService aisService;
	
	@RequestMapping(value="")
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
	public String edit(@RequestParam String id) throws Exception{
		Map<String, Object> editMap = aisService.getAisEditMap(Integer.parseInt(id));
		return null;
	}

}
