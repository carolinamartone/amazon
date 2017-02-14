package it.csttech.dao.hibernate;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.SessionFactory;
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


    @Override
    public List<T> findAll()
    {
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public void insert(T t)
    {
        // TODO Auto-generated method stub
        
    }


    @Override
    public void update(T t)
    {
        // TODO Auto-generated method stub
        
    }


    @Override
    public void delete(T t)
    {
        // TODO Auto-generated method stub
        
    }


}
