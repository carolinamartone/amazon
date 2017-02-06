package it.csttech.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import it.csttech.FlashMessage;
import it.csttech.manager.ArticoloManager;
import it.csttech.manager.CategoryManager;
import it.csttech.manager.RoleManager;
import it.csttech.manager.UserManager;
import it.csttech.manager.UserRolesManager;
import it.csttech.model.Role;
import it.csttech.model.User;
import it.csttech.model.UserRoles;

@SuppressWarnings("unused")
@Controller
@RequestMapping("users")
public class UserController {
	@Autowired
	public UserManager userManager;
	@Autowired
	public CategoryManager categoryManager;
	@Autowired
	public ArticoloManager articoloManager;
	@Autowired
	public UserRolesManager userRolesManager;
	@Autowired
	public RoleManager roleManager;

	@GetMapping("")
	public String listaUsers(ModelMap modelMap) {
		List<User> users = userManager.getAllUsers();
		modelMap.put("users", users);
		return "listaUsers";
	}

	@GetMapping("{id}")
	public String findById(@PathVariable int id, ModelMap modelMap) {
		User user = userManager.findById(id);
		modelMap.put("user", user);
		return "user-details";
	}

	@GetMapping("registrazione")
	public String formRegistrazione(ModelMap modelMap) {
		modelMap.addAttribute("submit", "Registrati");
		List<Role> roles = roleManager.getAllRoles();
		modelMap.put("roles", roles);
		return "formRegistrazione";
	}

	@PostMapping("registrazione")
	public String registrazione(User user, Long role_id, String password2, ModelMap modelMap,
			RedirectAttributes redirectAttributes) {

		List<User> users = userManager.getAllUsers();

		if (users.contains(user)) {
			redirectAttributes.addFlashAttribute("flash",
					new FlashMessage("username already exists!", FlashMessage.Status.FAILURE));
			return "redirect:registrazione";
		} else {
			if (!user.getUsername().equals(null)
					&& /*
						 * !user.getNome().equals(null) &&
						 * !user.getRuolo().equals(null) &&
						 */!user.getPassword().equals(null) && user.getPassword().equals(password2)) {
				user.setActive(true);
				userManager.save(user);
				modelMap.put("user", user);
				modelMap.put("username", user.getUsername());

				// modelMap.put("nome", user.getNome());
				// modelMap.put("ruolo", user.getRuolo());
				modelMap.put("password", user.getPassword());
				modelMap.put("password2", password2);
				Role role = roleManager.findById(role_id);
				UserRoles userRoles = new UserRoles(user, role);
				userRolesManager.save(userRoles);
				return "redirect:login";
			} else {
				redirectAttributes.addFlashAttribute("flash",
						new FlashMessage("Passwords don't match!", FlashMessage.Status.FAILURE));
				redirectAttributes.addFlashAttribute("username", user.getUsername());
				redirectAttributes.addFlashAttribute("password", user.getPassword());
				return "redirect:registrazione";
			}

		}

	}

	/*
	 * @GetMapping("login") public String formLogin(ModelMap modelMap) {
	 * modelMap.addAttribute("submit", "Login"); return "login";
	 * 
	 * }
	 * 
	 * 
	 * @PostMapping("login") public String login(ModelMap modelMap, String
	 * username, String password, RedirectAttributes redirectAttributes) { if
	 * (!username.equals(null) && !password.equals(null) &&
	 * userManager.findByUsername(username) != null &&
	 * userManager.findByUsername(username).getPassword().equals(password)) {
	 * List<Category> categories = categoryManager.getAllCategories();
	 * modelMap.put("categories", categories); List<Articolo> articoli =
	 * articoloManager.getAllArticoli(); modelMap.put("articoli", articoli);
	 * List<Category> categories2 = categoryManager.getAllCategories();
	 * modelMap.put("categories2", categories2);
	 * redirectAttributes.addFlashAttribute("flash", new
	 * FlashMessage("Benvenuto!", FlashMessage.Status.SUCCESS));
	 * 
	 * return "redirect:/categories"; } else { if
	 * (userManager.findByUsername(username) == null) {
	 * redirectAttributes.addFlashAttribute("flash", new
	 * FlashMessage("Username doesn't exist!", FlashMessage.Status.FAILURE)); }
	 * else if
	 * (!userManager.findByUsername(username).getPassword().equals(password)) {
	 * redirectAttributes.addFlashAttribute("flash", new
	 * FlashMessage("Password is wrong!", FlashMessage.Status.FAILURE));
	 * 
	 * } return "redirect:login";
	 * 
	 * }
	 * 
	 * }
	 */
}