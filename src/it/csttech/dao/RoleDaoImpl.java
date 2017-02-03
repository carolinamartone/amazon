package it.csttech.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import it.csttech.model.Role;

@Repository
@SuppressWarnings({ "unchecked" })

public class RoleDaoImpl implements RoleDao {
	@Autowired
	private SessionFactory sessionFactory;

	public Role findById(Long id) {
		Query query = sessionFactory.getCurrentSession().createQuery("FROM Role WHERE id=" + id);
		return (Role) query.getSingleResult();
	}

	public List<Role> getAllRoles() {
		Query query = sessionFactory.getCurrentSession().createQuery("FROM Role ORDER BY id ASC");
		return query.getResultList();
	}

}
