package it.csttech.manager;

import java.util.List;

import it.csttech.model.Articolo;
import it.csttech.model.Category;

public interface ArticoloManager {
	Articolo findById(int id);
	List<Articolo> getAllArticoli();
	List<Articolo>getAllArticoliOfCategory(Category category);
	List<Articolo>searchByString(String string);
	void save(Articolo articolo);
	void delete(Articolo articolo);
}
