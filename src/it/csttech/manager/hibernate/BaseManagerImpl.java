package it.csttech.manager.hibernate;

import java.io.Serializable;
import java.util.List;

import it.csttech.manager.BaseManager;

public class BaseManagerImpl<T extends Object>implements BaseManager<T>
{

    @Override
    public T findById(Serializable id)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<T> findAll()
    {
        // TODO Auto-generated method stub
        return null;
    }

}
