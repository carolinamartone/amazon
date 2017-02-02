package it.csttech.manager;

import java.util.List;

import it.csttech.model.Category;

public interface CategoryManager {
	Category findById(int id);
	List<Category> getAllCategories();
	void save(Category category);
	void delete(Category category);
}
