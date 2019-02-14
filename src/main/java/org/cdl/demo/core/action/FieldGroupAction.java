package org.cdl.demo.core.action;

import org.cdl.demo.core.entity.model.FieldGroup;
import org.cdl.demo.core.entity.model.Model;
import org.cdl.demo.core.service.model.FieldGroupService;
import org.cdl.demo.core.service.model.ModelServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/model/{model_id}/group")
public class FieldGroupAction {

	@Autowired
	private ModelServiceImpl modelService;

	@Autowired
	private FieldGroupService fieldGroupService;

	@ModelAttribute
	private final Model model(@PathVariable long model_id) {
		return modelService.findById(model_id);
	}

	@GetMapping("list")
	public String list(ModelMap map, @ModelAttribute Model model) {
		map.addAttribute("fieldGroups", model.getFieldGroups());
		return "admin/model/group/list";
	}

	@GetMapping(value = "add")
	public String add(ModelMap map, @ModelAttribute Model model) {
		FieldGroup fieldGroup = new FieldGroup();
		fieldGroup.setModel(model);
		map.addAttribute("fieldGroup", fieldGroup);
		return "admin/model/group/form";
	}

	@GetMapping(value = "edit")
	public String edit(ModelMap map, @RequestParam(required = true) Long id) {
		map.addAttribute("fieldGroup", fieldGroupService.findById(id));
		return "admin/model/group/form";
	}

	@PostMapping(value = "save")
	public String save(ModelMap map, @ModelAttribute FieldGroup fieldGroup) {
		fieldGroupService.save(fieldGroup);
		return "redirect:/model/{model_id}/group/list";
	}

	@GetMapping(value = "delete")
	public String delete(ModelMap map, @RequestParam(required = true) Long id) {
		fieldGroupService.delete(id);
		return "redirect:/model/{model_id}/group/list";
	}

}
