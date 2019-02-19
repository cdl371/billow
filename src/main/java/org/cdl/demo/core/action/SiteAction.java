package org.cdl.demo.core.action;

import java.util.List;
import java.util.Map;

import org.cdl.demo.core.entity.category.Category;
import org.cdl.demo.core.entity.category.SiteCategory;
import org.cdl.demo.core.entity.content.Site;
import org.cdl.demo.core.entity.model.Model;
import org.cdl.demo.core.service.content.SiteService;
import org.cdl.demo.core.service.model.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
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

	@Autowired
	@Qualifier("categoryMap")
	private Map<String, Category> categorys;

	@GetMapping("list")
	public String list(ModelMap map, @RequestParam(required = false) Long parent_id) {
		List<Model> models = modelService.findByCode(SiteCategory.CODE);
		map.addAttribute("models", models);
		if (parent_id == null) {
			map.addAttribute("sites", siteService.findAll());
		} else {
			Site parent = siteService.findById(parent_id);
			map.addAttribute("parent", parent);
			map.addAttribute("topSites", siteService.findByNodeParentIsNull());
			map.addAttribute("sites", siteService.findByNodeParentId(parent.getNode().getId()));
		}
		return "admin/site/list";
	}

	@GetMapping(value = "add")
	public String add(ModelMap map, @RequestParam Long model_id) {
		Site site = new Site();
		map.addAttribute("site", site);
		map.addAttribute("model_id", model_id);
		return "admin/site/form";
	}

	@GetMapping(value = "edit")
	public String edit(ModelMap map, @RequestParam Long id) {
		map.addAttribute("site", siteService.findById(id));
		return "admin/site/form";
	}

	@PostMapping(value = "save")
	public String save(ModelMap map, Site site, @RequestParam(required = false) Long model_id) {
		siteService.save(site, model_id == null ? null : modelService.findById(model_id));
		return "redirect:/site/list";
	}

	@GetMapping(value = "delete")
	public String delete(ModelMap map, @RequestParam Long id) {
		siteService.delete(id);
		return "redirect:/site/list";
	}

	@GetMapping("attach")
	public String attachParent(ModelMap map, @RequestParam Long id, @RequestParam Long parent_id,
			RedirectAttributes redirectAttrs) {
		siteService.attachParent(siteService.findById(id), siteService.findById(parent_id));
		redirectAttrs.addAttribute("parent_id", parent_id);
		return "redirect:/site/list";
	}

	@GetMapping("detach")
	public String detachParent(ModelMap map, @RequestParam Long id, @RequestParam Long parent_id,
			RedirectAttributes redirectAttrs) {
		siteService.detachParent(siteService.findById(id));
		redirectAttrs.addAttribute("parent_id", parent_id);
		return "redirect:/site/list";
	}

	@GetMapping("model/list")
	public String listModel(ModelMap map, @RequestParam Long site_id) {
		Sort sort = new Sort(Direction.ASC, "code");
		Site site = siteService.findById(site_id);
		map.addAttribute("site", site);
		map.addAttribute("allModels", modelService.findAll(sort));
		map.addAttribute("models", modelService.findByItemAssociationsContainerId(site.getContainer().getId(), sort));
		return "admin/site/model";
	}

	@GetMapping("model/attach")
	public String attachModel(ModelMap map, @RequestParam Long id, @RequestParam Long site_id,
			RedirectAttributes redirectAttrs) {
		Site site = siteService.findById(site_id);
		modelService.attachAssociation(modelService.findById(id), site);
		redirectAttrs.addAttribute("site_id", site_id);
		return "redirect:/site/model/list";
	}

	@GetMapping("model/detach")
	public String detachModel(ModelMap map, @RequestParam Long id, @RequestParam Long site_id,
			RedirectAttributes redirectAttrs) {
		Site site = siteService.findById(site_id);
		modelService.detachAssociation(modelService.findById(id), site);
		redirectAttrs.addAttribute("site_id", site_id);
		return "redirect:/site/model/list";
	}

}
