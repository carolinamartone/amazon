package it.csttech.manager.hibernate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.csttech.dao.UserDao;
import it.csttech.manager.UserManager;
import it.csttech.model.User;


@Service
public class UserManagerImpl extends BaseManagerImpl<User> implements UserManager
{

    @Autowired
    public UserDao userDao;

    @Override
    @Transactional(readOnly = true)
    public User findByUsername(String username)
    {
        return userDao.findByUsername(username);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> findByPassword(String password)
    {
        return userDao.findByPassword(password);
    }

    @Override
    public void insert(User user)
    {
        userDao.insert(user);
        
    }

}
