package it.csttech.manager;

import java.util.List;

import it.csttech.model.Articolo;
import it.csttech.model.Category;

public interface ArticoloManager extends BaseManager<Articolo> {
	List<Articolo>getAllArticoliOfCategory(Category category);
	List<Articolo>searchByString(String string);
	void insert(Articolo articolo);
	void update(Articolo articolo);
	void delete(Articolo articolo);
}
