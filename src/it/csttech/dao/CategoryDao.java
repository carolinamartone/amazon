package it.csttech.dao;
import java.util.List;

import it.csttech.model.Category;

public interface CategoryDao {
	Category findById(int id);
	List<Category> getAllCategories();
	void save(Category category);
	void delete(Category category);

}
