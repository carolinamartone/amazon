package it.csttech.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import it.csttech.model.UserRoles;

@SuppressWarnings({ "rawtypes", "unchecked" })
@Repository
public class UserRolesDaoImpl implements UserRolesDao {

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public List<UserRoles> findbyRole(String role) {
		Query query = sessionFactory.getCurrentSession().createQuery("FROM UserRoles WHERE role='" + role + "'");
		return query.getResultList();

	}

	public List<UserRoles> getAllUserRoles() {
		Query query = sessionFactory.getCurrentSession().createQuery("FROM UserRoles ORDER BY userRoleId ASC");
		return query.getResultList();

	}

	public UserRoles findByUsername(String username) {
		Query query = sessionFactory.getCurrentSession()
				.createQuery("FROM UserRoles WHERE username='" + username + "'");
		return (UserRoles) query.getSingleResult();
	}

	public UserRoles findById(int userRoleId) {
		Query query = sessionFactory.getCurrentSession().createQuery("FROM UserRoles WHERE userRoleId=" + userRoleId);
		return (UserRoles) query.getSingleResult();

	}
	public void save(UserRoles userRoles){
		sessionFactory.getCurrentSession().saveOrUpdate(userRoles);
	}

}
