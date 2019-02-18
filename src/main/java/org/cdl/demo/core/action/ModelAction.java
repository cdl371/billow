package org.cdl.demo.core.action;

import java.util.Map;

import org.cdl.demo.core.entity.category.Category;
import org.cdl.demo.core.entity.model.Model;
import org.cdl.demo.core.service.model.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/model")
public class ModelAction {

	@Autowired
	private ModelService modelService;

	@Autowired
	@Qualifier("categoryMap")
	private Map<String, Category> categorys;

	@ModelAttribute("categorys")
	private Map<String, Category> categorys() {
		return categorys;
	}

	@GetMapping("list")
	public String list(ModelMap map) {
		Sort sort = new Sort(Direction.ASC, "code");
		map.addAttribute("models", modelService.findAll(sort));
		return "admin/model/list";
	}

	@GetMapping("add")
	public String add(ModelMap map, @RequestParam String code) {
		map.addAttribute("model", new Model(code));
		return "admin/model/form";
	}

	@GetMapping("edit")
	public String edit(ModelMap map, @RequestParam Long id) {
		map.addAttribute("model", modelService.findById(id));
		return "admin/model/form";
	}

	@PostMapping("save")
	public String save(ModelMap map, Model model) {
		modelService.save(model);
		return "redirect:/model/list";
	}

	@GetMapping("delete")
	public String delete(ModelMap map, @RequestParam Long id) {
		modelService.delete(id);
		return "redirect:/model/list";
	}

}
