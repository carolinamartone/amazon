package it.csttech.dao;

import java.io.Serializable;
import java.util.List;


public interface BaseDao<T extends Object>
{
    T findById(Serializable id);

    List<T> findAll();

    void insert(T t);

    void update(T t);

    void delete(T t);

}
