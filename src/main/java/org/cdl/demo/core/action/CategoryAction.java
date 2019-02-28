package org.cdl.demo.core.action;

import java.util.List;

import org.cdl.demo.core.entity.category.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/category")
public class CategoryAction {

	@Autowired
	private List<Category> categorys;

	@GetMapping
	public String list(ModelMap map) {
		map.addAttribute("categorys", categorys);
		return "admin/category";
	}

}
