package it.csttech.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.csttech.dao.UserRolesDao;
import it.csttech.model.UserRoles;

@Service
public class UserRolesManagerImpl implements UserRolesManager{
	
	@Autowired
	public UserRolesDao userRolesDao;
	
	@Override
	@Transactional(readOnly=true)
	public List<UserRoles> findbyRole(String role){
		return userRolesDao.findbyRole(role);
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<UserRoles> getAllUserRoles(){
		return userRolesDao.getAllUserRoles();	
	}
	
	@Override
	@Transactional(readOnly=true)
	public UserRoles findByUsername(String username){
		return userRolesDao.findByUsername(username);
	}
	
	@Override
	@Transactional(readOnly=true)
	public UserRoles findById(int user_role_id){
		return userRolesDao.findById(user_role_id);
	}
}
