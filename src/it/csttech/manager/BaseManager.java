package it.csttech.manager;

import java.io.Serializable;
import java.util.List;

public interface BaseManager<T extends Object>
{
    T findById(Serializable id);

    List<T> findAll();
}
