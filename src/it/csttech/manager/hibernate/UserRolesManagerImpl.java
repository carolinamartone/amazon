package it.csttech.manager.hibernate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.csttech.dao.UserRolesDao;
import it.csttech.manager.UserRolesManager;
import it.csttech.model.UserRoles;


@Service
public class UserRolesManagerImpl extends BaseManagerImpl<UserRoles> implements UserRolesManager
{

    @Autowired
    public UserRolesDao userRolesDao;

    @Override
    @Transactional(readOnly = true)
    public List<UserRoles> findbyRole(String role)
    {
        return userRolesDao.findbyRole(role);
    }

    @Override
    @Transactional(readOnly = true)
    public UserRoles findByUsername(String username)
    {
        return userRolesDao.findByUsername(username);
    }

    @Override
    public void insert(UserRoles userRoles)
    {
       userRolesDao.insert(userRoles);
        
    }

}
