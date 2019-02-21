package org.cdl.demo.core.action;

import java.util.Map;

import org.cdl.demo.core.entity.model.FieldGroup;
import org.cdl.demo.core.entity.model.field.Field;
import org.cdl.demo.core.entity.model.field.FieldType;
import org.cdl.demo.core.service.model.FieldGroupService;
import org.cdl.demo.core.service.model.FieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "/model/field")
public class FieldAction {

	@Autowired
	private FieldService fieldService;

	@Autowired
	private FieldGroupService fieldGroupService;

	@Autowired
	@Qualifier("fieldTypeMap")
	private Map<String, FieldType<?>> fieldTypes;

	@ModelAttribute("fieldTypes")
	private final Map<String, FieldType<?>> fieldTypes() {
		return fieldTypes;
	}

	@GetMapping("list")
	public String list(ModelMap map, @RequestParam Long group_id) {
		FieldGroup fieldGroup = fieldGroupService.findById(group_id);
		map.addAttribute("fieldGroup", fieldGroup);
		map.addAttribute("fields", fieldGroup.getFields());
		return "admin/model/field/list";
	}

	@GetMapping("add")
	public String add(ModelMap map, @RequestParam Long group_id) {
		Field field = new Field();
		map.addAttribute("field", field);
		map.addAttribute("fieldGroup", fieldGroupService.findById(group_id));
		return "admin/model/field/form";
	}

	@GetMapping("edit")
	public String edit(ModelMap map, @RequestParam Long id) {
		map.addAttribute("field", fieldService.findById(id));
		return "admin/model/field/form";
	}

	@PostMapping("save")
	public String save(ModelMap map, Field field, @RequestParam Long group_id, RedirectAttributes redirectAttrs) {
		FieldGroup fieldGroup = fieldGroupService.findById(group_id);
		field.setFieldGroup(fieldGroup);
		fieldService.save(field);
		redirectAttrs.addAttribute("group_id", group_id);
		return "redirect:/model/field/list";
	}

	@GetMapping("delete")
	public String delete(ModelMap map, @RequestParam Long id, RedirectAttributes redirectAttrs) {
		Field field = fieldService.findById(id);
		fieldService.delete(id);
		redirectAttrs.addAttribute("group_id", field.getFieldGroup().getId());
		return "redirect:/model/field/list";
	}

}
