package it.csttech.dao.hibernate;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import it.csttech.dao.CategoryDao;
import it.csttech.model.Category;


@Repository
public class CategoryDaoImpl extends BaseDaoImpl<Category> implements CategoryDao
{
    //final indica che l'oggetto non pu� essere ricreato,ma pu� essere modificato
    //static dipende solo dalla classe e non dall'istanza � uguale per tutte le istanze.
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

}
