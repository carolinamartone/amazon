package it.csttech.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import it.csttech.model.Articolo;
import it.csttech.model.Category;

@Repository
public class ArticoloDaoImpl implements ArticoloDao {

	/*
	 * @PostConstruct public void init(){ allArticoli.add(new
	 * Articolo(1,"Portabiancheria",1)); allArticoli.add(new
	 * Articolo(2,"Tritadocumenti",2)); allArticoli.add(new
	 * Articolo(3,"Idrante",3)); allArticoli.add(new Articolo(4,"Cordless",4));
	 * }
	 */

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	public Articolo findById(int id) {

		// Session session = sessionFactory.openSession();
		/*
		 * for(Articolo articolo:allArticoli){ if(articolo.getId()==id){ return
		 * articolo; } } return null;
		 */
		/*
		 * Articolo articolo = session.get(Articolo.class, id); session.close();
		 * return articolo;
		 */
		// Session session = sessionFactory.openSession();
		Query query = sessionFactory.getCurrentSession().createQuery("FROM Articolo WHERE id=" + id);
		return (Articolo) query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	public List<Articolo> getAllArticoli() {
		/*
		 * Session session = sessionFactory.openSession(); CriteriaBuilder
		 * builder = session.getCriteriaBuilder(); CriteriaQuery<Articolo>
		 * criteria = builder.createQuery(Articolo.class);
		 * criteria.from(Articolo.class); List<Articolo>articoli =
		 * session.createQuery(criteria).getResultList(); session.close();
		 * return articoli;
		 */
		// Session session = sessionFactory.openSession();
		Query query = sessionFactory.getCurrentSession().createQuery("FROM Articolo ORDER BY id ASC ");

		List<Articolo> articoli = query.getResultList();
		return articoli;

	}

	@SuppressWarnings("unchecked")
	public List<Articolo> getAllArticoliOfCategory(Category category) {
		Query query = sessionFactory.getCurrentSession()
				.createQuery("FROM Articolo WHERE category_id=" + category.getId());

		List<Articolo> articoli = query.getResultList();
		return articoli;
	}

	public void save(Articolo articolo) {
		/*
		 * int maxId=0; for(Articolo articolo2:allArticoli){
		 * if(articolo2.getId()>maxId){ maxId=articolo2.getId(); } }
		 * if(articolo.getId()==0){ articolo.setId(maxId+1); }
		 * allArticoli.add(articolo);
		 */
		// Session session = sessionFactory.openSession();
		// session.beginTransaction();
		sessionFactory.getCurrentSession().saveOrUpdate(articolo);
		// session.getTransaction().commit();
		// session.close();
	}

	public void delete(Articolo articolo) {
		// allArticoli.remove(articolo);
		// Session session = sessionFactory.openSession();
		// session.beginTransaction();
		sessionFactory.getCurrentSession().delete(articolo);
		// session.getTransaction().commit();
		// session.close();

	}

}
