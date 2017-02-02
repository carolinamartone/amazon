package it.csttech.dao;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import it.csttech.model.User;

@Repository
public class UserDaoImpl implements UserDao {
	

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public User findById(int id){
		@SuppressWarnings("rawtypes")
		Query query = sessionFactory.getCurrentSession().createQuery("FROM User WHERE id="+id);
		User user;
		try{
			user = (User) query.getSingleResult();
		}catch(NoResultException ex){
			user = null;
		}
		
		return user;	
	}
	@SuppressWarnings({"unchecked","rawtypes"})
	public List<User>getAllUsers(){
		Query query=sessionFactory.getCurrentSession().createQuery("FROM User ORDER BY id ASC");
		return query.getResultList();
		
	}
	/*@SuppressWarnings("unchecked")
	public List<User> findByRuolo(Ruolo ruolo){
		@SuppressWarnings("rawtypes")
		Query query=sessionFactory.getCurrentSession().createQuery("FROM User WHERE ruolo="+ruolo);
		return query.getResultList();
	}*/
	@SuppressWarnings("rawtypes")
	public User findByUsername(String username){
		Query query = sessionFactory.getCurrentSession().createQuery("FROM User WHERE username='"+username+"'");
		User user;
		try{
			user = (User) query.getSingleResult();
		}catch(NoResultException ex){
			user = null;
		}
		return user;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<User> findByPassword(String password){
		Query query = sessionFactory.getCurrentSession().createQuery("FROM User WHERE password='"+password+"'");
		return query.getResultList();
	}
	
	public void save(User user){
		sessionFactory.getCurrentSession().saveOrUpdate(user);
	}
	
	public void delete(User user){
		sessionFactory.getCurrentSession().delete(user);
	}
}
