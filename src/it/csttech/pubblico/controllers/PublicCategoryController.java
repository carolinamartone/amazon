package it.csttech.pubblico.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.csttech.manager.ArticoloManager;
import it.csttech.manager.CategoryManager;
import it.csttech.model.Articolo;
import it.csttech.model.Category;

@Controller
// @RequestMapping("categories")
public class PublicCategoryController {
	@Autowired
	public CategoryManager categoryManager;

	@Autowired
	public ArticoloManager articoloManager;

	public CategoryManager getCategoryManager() {
		return categoryManager;
	}

	public void setCategoryManager(CategoryManager categoryManager) {
		this.categoryManager = categoryManager;
	}

	@RequestMapping(value = "categories", method = RequestMethod.GET)
	public String listaCategories(ModelMap modelMap) {
		List<Category> categories = categoryManager.getAllCategories();
		List<Articolo> articoli = articoloManager.getAllArticoli();
		modelMap.put("categories", categories);
		modelMap.put("articoli", articoli);
		List<Category> categories2 = categoryManager.getAllCategories();
		modelMap.put("categories2", categories2);
		// modelMap.addAttribute("heading","AllCategories");
		return "/public/category/listaCategories";
	}

	@RequestMapping(value = "categories/{id}", method = RequestMethod.GET)
	public String showDetails(@PathVariable int id, ModelMap modelMap) {
		Category category = categoryManager.findById(id);
		modelMap.put("category", category);
		List<Articolo> articoli = articoloManager.getAllArticoli();
		List<Category> categories = categoryManager.getAllCategories();
		modelMap.put("categories", categories);
		modelMap.put("articoli", articoli);
		// modelMap.addAttribute("heading","CategoryDetails");
		return "/public/category/category-details";
	}

	@RequestMapping("categories/{id}/articoli")
	public String getAllArticoliOfCategory(@PathVariable int id, ModelMap modelMap) {
		List<Articolo> articoli = articoloManager.getAllArticoliOfCategory(categoryManager.findById(id));
		modelMap.put("articoli", articoli);
		List<Category> categories = categoryManager.getAllCategories();
		modelMap.put("categories", categories);
		return "/public/category/listaArticoliCategory";
	}
}
