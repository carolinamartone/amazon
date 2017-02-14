package it.csttech.dao.hibernate;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import it.csttech.dao.UserDao;
import it.csttech.model.User;


@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao
{

    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory()
    {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory)
    {
        this.sessionFactory = sessionFactory;
    }

    @SuppressWarnings("rawtypes")
    public User findByUsername(String username)
    {
        Query query = sessionFactory.getCurrentSession().createQuery("FROM User WHERE username='" + username + "'");
        User user;
        try
        {
            user = (User) query.getSingleResult();
        }
        catch (NoResultException ex)
        {
            user = null;
        }
        return user;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public List<User> findByPassword(String password)
    {
        Query query = sessionFactory.getCurrentSession().createQuery("FROM User WHERE password='" + password + "'");
        return query.getResultList();
    }

}
