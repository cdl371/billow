package org.cdl.demo.core.action;

import java.util.Map;

import org.cdl.demo.core.entity.model.field.FieldType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FieldTypeAction {

	@Autowired
	@Qualifier("fieldTypeMap")
	private Map<String, FieldType<?>> fieldTypes;

	@GetMapping("/model/field/type")
	public String list(ModelMap map) {
		map.addAttribute("fieldTypes", fieldTypes);
		return "admin/model/field/type";
	}

}
