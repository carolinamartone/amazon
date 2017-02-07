package it.csttech.dao;

import java.util.List;

import javax.persistence.Query;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import it.csttech.model.Category;


@Repository
public class CategoryDaoImpl implements CategoryDao{
	private static Logger log = LogManager.getLogger(CategoryDaoImpl.class);
	//final indica che l'oggetto non può essere ricreato,ma può essere modificato
	//static dipende solo dalla classe e non dall'istanza è uguale per tutte le istanze.
	

	/*@PostConstruct
	public void init()
	{
		allCategories.add(new Category(1,"Casa"));
		allCategories.add(new Category(2,"Ufficio"));
		allCategories.add(new Category(3,"Giardino"));
		allCategories.add(new Category(4,"Telefonia"));
		
	}*/
	@Autowired 
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	public Category findById(int id){
		 Category category =  sessionFactory.getCurrentSession().get(Category.class,id);
		 Query query = sessionFactory.getCurrentSession().createQuery("FROM Category WHERE id="+id);
		 System.out.println("Sto cercando una category tramite id"+id);
		 return category;
		 /*
		 Category category = session.get(Category.class,id);
		 session.close();
		 return category;
		/*for(Category category:allCategories){
			if(category.getId() == id){
				return category;
			}
       }
		return null;
		*/
   }
	
	public List<Category> getAllCategories()
	{
		
		/*		
		System.out.println("Procedura iniziata correttamente.");
//		Session session = sessionFactory.getCurrentSession();
		List<Category> categories = sessionFactory.getCurrentSession().createQuery("from Categories").getResultList();
//		session.close();
		return categories;
		*/
		//apro sessione
		//Session session = sessionFactory.openSession();
		Query query = sessionFactory.getCurrentSession().createQuery("FROM Category ORDER BY id ASC ");
		@SuppressWarnings("unchecked")
		List<Category> categories = query.getResultList();
		return categories;
		
	/*	@SuppressWarnings("deprecation")
		Criteria criteria = session.createCriteria(Category.class);
		criteria.addOrder(Order.asc("id"));
		return criteria.list();
		*/
		  
	}
	
	public void save(Category category){
		/*int maxId=0;
		for(Category category2:allCategories){
			if(category2.getId()>maxId){
				maxId=category2.getId();
			}	
		}
		if(category.getId()==0){
			category.setId(maxId+1);
		}
		 allCategories.add(category);
		 */
		//Session session = sessionFactory.openSession();
		//session.beginTransaction();
		sessionFactory.getCurrentSession().saveOrUpdate(category);
		System.out.println("Sto aggiungendo/modificando la categoria:"+category);
		//session.getTransaction().commit();
		//session.close();
	}
	
	
	public void delete(Category category){
//		allCategories.remove(category);
		//Session session = sessionFactory.openSession();
        //session.beginTransaction();
        log.info("Sto eliminando la categoria :"+category);
        sessionFactory.getCurrentSession().delete(category);
        //session.getTransaction().commit();
        //session.close();
	}
	
	
	
	
}
	


