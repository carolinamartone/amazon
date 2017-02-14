package it.csttech.manager;

import it.csttech.model.Category;

public interface CategoryManager extends BaseManager<Category>{
	void insert(Category category);
	void delete(Category category);
}
