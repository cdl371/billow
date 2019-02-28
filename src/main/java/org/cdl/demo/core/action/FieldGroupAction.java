package org.cdl.demo.core.action;

import org.cdl.demo.core.entity.model.FieldGroup;
import org.cdl.demo.core.entity.model.Model;
import org.cdl.demo.core.service.model.FieldGroupService;
import org.cdl.demo.core.service.model.ModelServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/model/group")
public class FieldGroupAction {

	@Autowired
	private ModelServiceImpl modelService;

	@Autowired
	private FieldGroupService fieldGroupService;

	@GetMapping("list")
	public String list(ModelMap map, @RequestParam Long model_id) {
		Model model = modelService.findById(model_id);
		map.addAttribute("model", model);
		map.addAttribute("fieldGroups", model.getFieldGroups());
		return "admin/model/group/list";
	}

	@GetMapping("add")
	public String add(ModelMap map, @RequestParam Long model_id) {
		map.addAttribute("fieldGroup", new FieldGroup());
		map.addAttribute("model", modelService.findById(model_id));
		return "admin/model/group/form";
	}

	@GetMapping("edit")
	public String edit(ModelMap map, @RequestParam Long id) {
		map.addAttribute("fieldGroup", fieldGroupService.findById(id));
		return "admin/model/group/form";
	}

	@PostMapping("save")
	public String save(ModelMap map, FieldGroup fieldGroup, @RequestParam Long model_id,
			RedirectAttributes redirectAttrs) {
		Model model = modelService.findById(model_id);
		fieldGroup.setModel(model);
		fieldGroupService.save(fieldGroup);
		redirectAttrs.addAttribute("model_id", model_id);
		return "redirect:/model/group/list";
	}

	@GetMapping("delete")
	public String delete(ModelMap map, @RequestParam Long id, RedirectAttributes redirectAttrs) {
		FieldGroup fieldGroup = fieldGroupService.findById(id);
		fieldGroupService.delete(id);
		redirectAttrs.addAttribute("model_id", fieldGroup.getModel().getId());
		return "redirect:/model/group/list";
	}

}
