package it.csttech.dao;

import java.util.List;

import it.csttech.model.Articolo;
import it.csttech.model.Category;

public interface ArticoloDao {
	Articolo findById(int id);
	List<Articolo> getAllArticoli();
	List<Articolo>getAllArticoliOfCategory(Category category);
	void save(Articolo articolo);
	void delete(Articolo articolo);
}
