package it.csttech.dao;

import java.util.List;

import it.csttech.model.Articolo;
import it.csttech.model.Category;


public interface ArticoloDao extends BaseDao<Articolo>
{
    List<Articolo> getAllArticoliOfCategory(Category category);

    List<Articolo> searchByString(String string);
}
