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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "/site")
public class SiteAction {

	@Autowired
	private SiteService siteService;

	@Autowired
	private ModelService modelService;

	@GetMapping("list")
	public String list(ModelMap map, @RequestParam(required = false) Long parent_id) {
		List<Model> models = modelService.findByCode(SiteCategory.CODE);
		map.addAttribute("models", models);
		if (parent_id == null) {
			map.addAttribute("sites", siteService.findAll());
		} else {
			Site parent = siteService.findById(parent_id);
			map.addAttribute("parent", parent);
			map.addAttribute("idleSites", siteService.findByNodeLeafTrueAndNodeParentIsNull());
			map.addAttribute("sites", siteService.findByNodeParentId(parent.getNode().getId()));
		}
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

	@GetMapping("attach")
	public String attach(ModelMap map, @RequestParam Long id, @RequestParam Long parent_id,
			RedirectAttributes redirectAttrs) {
		//此处应该用nodeAwareService实现
//		siteService.attachAssociation(siteService.findById(id), siteService.findById(parent_id));
		redirectAttrs.addAttribute("parent_id", parent_id);
		return "redirect:/model/list";
	}

	@GetMapping("detach")
	public String detach(ModelMap map, @RequestParam Long id, @RequestParam Long parent_id,
			RedirectAttributes redirectAttrs) {
//		siteService.detachAssociation(siteService.findById(id).getContainer().getId(),
//				siteService.findById(parent_id).getContainer().getId());
		redirectAttrs.addAttribute("parent_id", parent_id);
		return "redirect:/model/list";
	}

}
