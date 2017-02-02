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
//@RequestMapping("articoli")
public class ArticoloController {
	@Autowired
	public ArticoloManager articoloManager;
	@Autowired
	public CategoryManager categoryManager;
	
	
	@GetMapping("articoli")
	public String listaArticoli(ModelMap modelMap){
		List<Articolo> articoli=articoloManager.getAllArticoli();
		List<Category> categories=categoryManager.getAllCategories();
		modelMap.put("categories", categories);
		modelMap.put("articoli",articoli);
		
		return "listaArticoli";
	}
	
	@GetMapping("articoli/{id}")
	public String getDetails(@PathVariable int id,ModelMap modelMap){
		Articolo articolo = articoloManager.findById(id);
		modelMap.put("articolo", articolo);
		List<Articolo> articoli=articoloManager.getAllArticoli();
		List<Category> categories=categoryManager.getAllCategories();
		modelMap.put("categories", categories);
		modelMap.put("articoli",articoli);
		return "articolo-details";
	}
	
	@GetMapping("admin/articoli/create")
	public String formCreate(ModelMap modelMap){
		List<Articolo> articoli=articoloManager.getAllArticoli();
		List<Category> categories=categoryManager.getAllCategories();
		modelMap.put("categories", categories);
		modelMap.put("articoli",articoli);
		modelMap.addAttribute("submit","Add");
		return "formCreateArticolo";
	}
	
	@RequestMapping(value="admin/articoli",method = RequestMethod.POST)
	public String create(Articolo articolo,ModelMap modelMap,RedirectAttributes redirectAttributes){
		articoloManager.save(articolo);
		redirectAttributes.addFlashAttribute("flash",new FlashMessage("Articolo aggiunto!",FlashMessage.Status.SUCCESS));
		List<Articolo> articoli=articoloManager.getAllArticoli();
		List<Category> categories=categoryManager.getAllCategories();
		modelMap.put("categories", categories);
		modelMap.put("articoli",articoli);
		return "redirect:/articoli";
		
	}
	
	
	@RequestMapping(value="admin/articoli/{id}/delete",method = RequestMethod.GET)
	public String delete(@PathVariable int id,ModelMap modelMap,RedirectAttributes redirectAttributes){
		Articolo articolo = articoloManager.findById(id);
		articoloManager.delete(articolo);
		redirectAttributes.addFlashAttribute("flash",new FlashMessage("Articolo eliminato!",FlashMessage.Status.SUCCESS));
		List<Articolo> articoli=articoloManager.getAllArticoli();
		List<Category> categories=categoryManager.getAllCategories();
		modelMap.put("categories", categories);
		modelMap.put("articoli",articoli);
		return "redirect:/articoli";
	}
	
	@GetMapping("admin/articoli/{id}/update")
	public String formUpdate(@PathVariable int id,ModelMap modelMap){
		Articolo articolo = articoloManager.findById(id);
		modelMap.put("articolo", articolo);
		List<Articolo> articoli=articoloManager.getAllArticoli();
		List<Category> categories=categoryManager.getAllCategories();
		modelMap.put("categories", categories);
		modelMap.put("articoli",articoli);
		return "formUpdateArticolo";
	}
	
	@RequestMapping(value="admin/articoli/update",method = RequestMethod.POST)
	public String update(Articolo articolo,ModelMap modelMap){
		articoloManager.save(articolo);
		List<Articolo> articoli=articoloManager.getAllArticoli();
		List<Category> categories=categoryManager.getAllCategories();
		modelMap.put("categories", categories);
		modelMap.put("articoli",articoli);
		return "redirect:/articoli";
		
	}
	

}
