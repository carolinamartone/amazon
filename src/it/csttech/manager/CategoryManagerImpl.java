package it.csttech.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import it.csttech.dao.CategoryDao;
import it.csttech.model.Category;

@Service
public class CategoryManagerImpl implements CategoryManager{
	@Autowired
	public CategoryDao categoryDao;
	
	@Override
	@Transactional(readOnly = true )
	public Category findById(int id){
		return categoryDao.findById(id);
	}
	
	@Override
	@Transactional(readOnly = true )
	public List<Category> getAllCategories(){
		return categoryDao.getAllCategories();
		
	}
	
	@Override
    @Transactional(readOnly = false )
	public void save(Category category){
		categoryDao.save(category);
	}
	
	@Override
	@Transactional(readOnly = false , propagation = Propagation.REQUIRES_NEW)
	public void delete(Category category){
		categoryDao.delete(category);
		
	}

	public CategoryDao getCategoryDao() {
		return categoryDao;
	}

	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}
	
	
	
}
