package it.csttech.manager.hibernate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import it.csttech.dao.CategoryDao;
import it.csttech.manager.CategoryManager;
import it.csttech.model.Category;


@Service
public class CategoryManagerImpl extends BaseManagerImpl<Category> implements CategoryManager
{
    @Autowired
    public CategoryDao categoryDao;

    @Override
    @Transactional(readOnly = false,propagation = Propagation.REQUIRED)
    public void insert(Category category)
    {
        categoryDao.insert(category);
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public void delete(Category category)
    {
        categoryDao.delete(category);

    }

    public CategoryDao getCategoryDao()
    {
        return categoryDao;
    }

    public void setCategoryDao(CategoryDao categoryDao)
    {
        this.categoryDao = categoryDao;
    }

}
