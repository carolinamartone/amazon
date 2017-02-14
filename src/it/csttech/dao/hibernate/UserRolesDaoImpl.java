package it.csttech.dao.hibernate;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import it.csttech.dao.UserRolesDao;
import it.csttech.model.UserRoles;

@SuppressWarnings({ "rawtypes", "unchecked" })
@Repository
public class UserRolesDaoImpl extends BaseDaoImpl<UserRoles> implements UserRolesDao {

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


	public UserRoles findByUsername(String username) {
		Query query = sessionFactory.getCurrentSession()
				.createQuery("FROM UserRoles WHERE username='" + username + "'");
		return (UserRoles) query.getSingleResult();
	}

}
