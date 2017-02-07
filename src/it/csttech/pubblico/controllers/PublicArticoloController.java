package it.csttech.pubblico.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import it.csttech.manager.ArticoloManager;
import it.csttech.manager.CategoryManager;
import it.csttech.model.Articolo;
import it.csttech.model.Category;

@Controller
// @RequestMapping("articoli")
public class PublicArticoloController {
	@Autowired
	public ArticoloManager articoloManager;
	@Autowired
	public CategoryManager categoryManager;

	@GetMapping("articoli")
	public String listaArticoli(ModelMap modelMap) {
		List<Articolo> articoli = articoloManager.getAllArticoli();
		List<Category> categories = categoryManager.getAllCategories();
		modelMap.put("categories", categories);
		modelMap.put("articoli", articoli);

		return "/public/articolo/listaArticoli";
	}

	@GetMapping("articoli/{id}")
	public String getDetails(@PathVariable int id, ModelMap modelMap) {
		Articolo articolo = articoloManager.findById(id);
		modelMap.put("articolo", articolo);
		List<Articolo> articoli = articoloManager.getAllArticoli();
		List<Category> categories = categoryManager.getAllCategories();
		modelMap.put("categories", categories);
		modelMap.put("articoli", articoli);
		return "/public/articolo/articolo-details";
	}

}
