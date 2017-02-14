package it.csttech.dao.hibernate;

import org.springframework.stereotype.Repository;

import it.csttech.dao.CategoryDao;
import it.csttech.model.Category;


@Repository
public class CategoryDaoImpl extends BaseDaoImpl<Category> implements CategoryDao
{
    //final indica che l'oggetto non pu� essere ricreato,ma pu� essere modificato
    //static dipende solo dalla classe e non dall'istanza � uguale per tutte le istanze.
    

}
