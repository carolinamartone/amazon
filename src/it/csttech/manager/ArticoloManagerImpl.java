package it.csttech.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import it.csttech.dao.ArticoloDao;
import it.csttech.model.Articolo;
import it.csttech.model.Category;

@Service
public class ArticoloManagerImpl implements ArticoloManager
{
	@Autowired
	public ArticoloDao articoloDao;
	
	@Override
	@Transactional(readOnly = true )
	public Articolo findById(int id){
		return articoloDao.findById(id);
	}
	
	@Override
	@Transactional(readOnly = true )
	public List<Articolo> getAllArticoli(){
		return articoloDao.getAllArticoli();	
	}
	
	@Override
	@Transactional(readOnly = true )
	public List<Articolo> getAllArticoliOfCategory(Category category){
		return articoloDao.getAllArticoliOfCategory(category);
	}
	@Override
	@Transactional(readOnly = false)
	public void save (Articolo articolo){
		articoloDao.save(articolo);
		
	}

	
	@Override
	@Transactional(readOnly = false,propagation = Propagation.REQUIRES_NEW)
	public void delete(Articolo articolo){
		articoloDao.delete(articolo);
		
	}
}
	