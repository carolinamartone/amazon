package it.csttech.dao.hibernate;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import it.csttech.dao.ArticoloDao;
import it.csttech.model.Articolo;
import it.csttech.model.Category;


@Repository
public class ArticoloDaoImpl extends BaseDaoImpl<Articolo> implements ArticoloDao
{

    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory()
    {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory)
    {
        this.sessionFactory = sessionFactory;
    }

    @SuppressWarnings("unchecked")
    public List<Articolo> getAllArticoliOfCategory(Category category)
    {
        Query query = sessionFactory.getCurrentSession().createQuery("FROM Articolo WHERE category_id=" + category.getId());

        List<Articolo> articoli = query.getResultList();
        return articoli;
    }

    @SuppressWarnings("unchecked")
    public List<Articolo> searchByString(String string)
    {
        Query query = sessionFactory.getCurrentSession().createQuery("FROM Articolo WHERE LOWER(name) LIKE LOWER ('" + string + "%')");
        List<Articolo> articoli = query.getResultList();
        return articoli;
    }

}
