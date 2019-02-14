package org.cdl.demo.core.action;

import org.cdl.demo.core.entity.model.FieldGroup;
import org.cdl.demo.core.entity.model.field.Field;
import org.cdl.demo.core.entity.model.field.FieldTypeConfiguration;
import org.cdl.demo.core.service.model.FieldGroupService;
import org.cdl.demo.core.service.model.FieldService;
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
@RequestMapping(value = "/model/group/{group_id}/field")
public class FieldAction {

	@Autowired
	private FieldTypeConfiguration fieldTypes;

	@Autowired
	private FieldService fieldService;

	@Autowired
	private FieldGroupService fieldGroupService;

	@ModelAttribute
	private final FieldGroup fieldGroup(@PathVariable long group_id) {
		return fieldGroupService.findById(group_id);
	}

	@ModelAttribute("fieldTypes")
	private final FieldTypeConfiguration fieldTypes() {
		return fieldTypes;
	}

	@GetMapping("list")
	public String list(ModelMap map, @ModelAttribute FieldGroup fieldGroup) {
		map.addAttribute("fields", fieldGroup.getFields());
		return "admin/model/field/list";
	}

	@GetMapping(value = "add")
	public String add(ModelMap map, @ModelAttribute FieldGroup fieldGroup) {
		Field field = new Field();
		field.setFieldGroup(fieldGroup);
		map.addAttribute("field", field);
		return "admin/model/field/form";
	}

	@GetMapping(value = "edit")
	public String edit(ModelMap map, @RequestParam(required = true) Long id) {
		map.addAttribute("field", fieldService.findById(id));
		return "admin/model/field/form";
	}

	@PostMapping(value = "save")
	public String save(ModelMap map, @ModelAttribute Field field) {
		fieldService.save(field);
		return "redirect:/model/group/{group_id}/field/list";
	}

	@GetMapping(value = "delete")
	public String delete(ModelMap map, @RequestParam(required = true) Long id) {
		fieldService.delete(id);
		return "redirect:/model/group/{group_id}/field/list";
	}

}
