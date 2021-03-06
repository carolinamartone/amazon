package it.csttech.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import it.csttech.FlashMessage;
import it.csttech.manager.ArticoloManager;
import it.csttech.manager.CategoryManager;
import it.csttech.model.Articolo;
import it.csttech.model.Category;

@Controller
//@RequestMapping("categories")
public class CategoryController {
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

	@RequestMapping(value="categories", method=RequestMethod.GET)
	public String listaCategories(ModelMap modelMap){
		List<Category> categories=categoryManager.getAllCategories();
		List<Articolo> articoli=articoloManager.getAllArticoli();
		modelMap.put("categories", categories);
		modelMap.put("articoli",articoli);
		List<Category> categories2=categoryManager.getAllCategories();
		modelMap.put("categories2", categories2);
//		modelMap.addAttribute("heading","AllCategories");
		return "listaCategories";
	}
	
	@RequestMapping(value="categories/{id}", method=RequestMethod.GET)
	public String showDetails(@PathVariable int id,ModelMap modelMap){
		Category category = categoryManager.findById(id);
		modelMap.put("category",category);
		List<Articolo> articoli=articoloManager.getAllArticoli();
		List<Category> categories=categoryManager.getAllCategories();
		modelMap.put("categories", categories);
		modelMap.put("articoli",articoli);
		//modelMap.addAttribute("heading","CategoryDetails");
		return "category-details";	
	}
	
	@GetMapping("admin/categories/create")
	public String formCreate(ModelMap modelMap){
		modelMap.addAttribute("submit","Add");
		List<Articolo> articoli=articoloManager.getAllArticoli();
		List<Category> categories=categoryManager.getAllCategories();
		modelMap.put("categories", categories);
		modelMap.put("articoli",articoli);
		return "formCreateCategory";
	}
	
	@RequestMapping(value="admin/categories",method = RequestMethod.POST)
	public String create(Category category,ModelMap modelMap,RedirectAttributes redirectAttributes ){
		List<Articolo> articoli=articoloManager.getAllArticoli();
		List<Category> categories=categoryManager.getAllCategories();
		modelMap.put("categories", categories);
		modelMap.put("articoli",articoli);
		if(categories.contains(category)){
			redirectAttributes.addFlashAttribute("flash",new FlashMessage("Category already exists!",FlashMessage.Status.FAILURE));	
			return "redirect:create";
		}
		else{
			categoryManager.save(category);
			List<Category> categories2=categoryManager.getAllCategories();
			modelMap.put("categories2", categories2);
			redirectAttributes.addFlashAttribute("flash",new FlashMessage("Category added!",FlashMessage.Status.SUCCESS));
			return "redirect:/categories";
		
		}
		
		
		
	}
	@GetMapping("admin/categories/{id}/update")
	public String formUpdate(@PathVariable int id,ModelMap modelMap){
		if(!modelMap.containsAttribute("category")) {
            modelMap.addAttribute("category",categoryManager.findById(id));
		}
		//modelMap.addAttribute("heading","UpdateCategory");
		modelMap.addAttribute("submit","Update");
		List<Articolo> articoli=articoloManager.getAllArticoli();
		List<Category> categories=categoryManager.getAllCategories();
		modelMap.put("categories", categories);
		modelMap.put("articoli",articoli);
		return "formUpdateCategory";	
	}
	
	@RequestMapping(value="admin/categories/update",method= RequestMethod.POST)
	public String update(Category category,ModelMap modelMap,RedirectAttributes redirectAttributes ){
		categoryManager.save(category);
		redirectAttributes.addFlashAttribute("flash",new FlashMessage("Category updated!",FlashMessage.Status.SUCCESS));
		List<Articolo> articoli=articoloManager.getAllArticoli();
		List<Category> categories=categoryManager.getAllCategories();
		modelMap.put("categories", categories);
		modelMap.put("articoli",articoli);
		return "redirect:/categories";	
	}
	
	@RequestMapping(value="admin/categories/{id}/delete",method=RequestMethod.GET)
	public String delete(@PathVariable int id,ModelMap modelMap,RedirectAttributes redirectAttributes ){
		if(!modelMap.containsAttribute("category")) {
            modelMap.addAttribute("category",categoryManager.findById(id));
		}
		Category category= categoryManager.findById(id);
		categoryManager.delete(category);
		redirectAttributes.addFlashAttribute("flash",new FlashMessage("Category deleted!",FlashMessage.Status.SUCCESS));
		List<Articolo> articoli=articoloManager.getAllArticoli();
		List<Category> categories=categoryManager.getAllCategories();
		modelMap.put("categories", categories);
		modelMap.put("articoli",articoli);
        return "redirect:/categories";	
	}
	@RequestMapping("categories/{id}/articoli")
	public String getAllArticoliOfCategory (@PathVariable int id,ModelMap modelMap){
		List<Articolo> articoli =articoloManager.getAllArticoliOfCategory(categoryManager.findById(id));
		modelMap.put("articoli", articoli);
		List<Category> categories=categoryManager.getAllCategories();
		modelMap.put("categories", categories);
		return "listaArticoliCategory";
	}
}
	
