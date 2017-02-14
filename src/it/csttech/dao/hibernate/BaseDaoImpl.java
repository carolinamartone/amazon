package it.csttech.dao.hibernate;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import it.csttech.dao.BaseDao;

@Transactional(propagation = Propagation.MANDATORY)
public class BaseDaoImpl<T extends Object> implements BaseDao<T>
{
    private Class<T> entityClass;

    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    BaseDaoImpl()
    {
        this.entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }


    @Override
    public T findById(Serializable id)
    {
        return sessionFactory.getCurrentSession().get(entityClass, id);
    }


    @SuppressWarnings("unchecked")
    @Override
    public List<T> findAll()
    {
        @SuppressWarnings("rawtypes")
        Query query = sessionFactory.getCurrentSession().createQuery("FROM "+entityClass.getName());
        List<T> all = query.getResultList();
        return all;
    }


    @Override
    public void insert(T t)
    {
      sessionFactory.getCurrentSession().save(t);
    }


    @Override
    public void update(T t)
    {
       sessionFactory.getCurrentSession().update(t);
    }


    @Override
    public void delete(T t)
    {
       sessionFactory.getCurrentSession().delete(t);
        
    }


}
