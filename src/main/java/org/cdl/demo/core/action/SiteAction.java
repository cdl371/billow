package org.cdl.demo.core.action;

import java.util.List;

import org.cdl.demo.core.entity.category.SiteCategory;
import org.cdl.demo.core.entity.content.Site;
import org.cdl.demo.core.entity.model.Model;
import org.cdl.demo.core.service.content.SiteService;
import org.cdl.demo.core.service.model.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/site")
public class SiteAction {

	@Autowired
	private SiteService siteService;

	@Autowired
	private ModelService modelService;

	@GetMapping("list")
	public String list(ModelMap map) {
		List<Model> models = modelService.findByCode(SiteCategory.CODE);
		map.addAttribute("models", models);
		map.addAttribute("sites", siteService.findAll());
		return "admin/site/list";
	}

	@GetMapping(value = "add")
	public String add(ModelMap map, @RequestParam Long model_id) {
		Site site = new Site();
		map.addAttribute("site", site);
		map.addAttribute("sites", siteService.findAll());
		map.addAttribute("model_id", model_id);
		return "admin/site/form";
	}

	@GetMapping(value = "edit")
	public String edit(ModelMap map, @RequestParam Long id) {
		map.addAttribute("site", siteService.findById(id));
		map.addAttribute("sites", siteService.findAll());
		return "admin/site/form";
	}

	@PostMapping(value = "save")
	public String save(ModelMap map, Site site, @RequestParam Long model_id, Long parent_node_id) {
		siteService.save(site, model_id, parent_node_id);
		return "redirect:/site/list";
	}

	@GetMapping(value = "delete")
	public String delete(ModelMap map, @RequestParam Long id) {
		siteService.delete(id);
		return "redirect:/site/list";
	}

}
