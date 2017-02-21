package it.csttech.manager.hibernate;

import java.io.Serializable;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import it.csttech.dao.BaseDao;
import it.csttech.manager.BaseManager;


public class BaseManagerImpl<T extends Object> implements BaseManager<T>
{

    @Autowired
    SessionFactory sessionFactory;
    @Autowired
    private BaseDao<T> baseDao;

    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    @Override
    public T findById(Serializable id)
    {
        return baseDao.findById(id);
    }

    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    @Override
    public List<T> findAll()
    {
        return baseDao.findAll();
    }

}
