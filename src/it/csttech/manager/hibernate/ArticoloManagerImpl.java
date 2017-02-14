package it.csttech.manager.hibernate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import it.csttech.dao.ArticoloDao;
import it.csttech.manager.ArticoloManager;
import it.csttech.model.Articolo;
import it.csttech.model.Category;


@Service
public class ArticoloManagerImpl extends BaseManagerImpl<Articolo>implements ArticoloManager
{
    @Autowired
    public ArticoloDao articoloDao;

    @Override
    @Transactional(readOnly = true)
    public List<Articolo> getAllArticoliOfCategory(Category category)
    {
        return articoloDao.getAllArticoliOfCategory(category);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Articolo> searchByString(String string)
    {
        return articoloDao.searchByString(string);
    }


    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public void delete(Articolo articolo)
    {
        articoloDao.delete(articolo);

    }

    @Override
    public void insert(Articolo articolo)
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void update(Articolo articolo)
    {
        // TODO Auto-generated method stub
        
    }
}
