package it.csttech.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.csttech.dao.UserDao;
import it.csttech.model.User;

@Service
public class UserManagerImpl implements UserManager{
	
	@Autowired
	public UserDao userDao;
	
	@Override
	@Transactional(readOnly = true )
	public User findById(int id){
		return userDao.findById(id);
		
	}
	
	@Override
	@Transactional(readOnly = true )
	public List<User>getAllUsers(){
		return userDao.getAllUsers();
	}
	
	/*@Override
	@Transactional(readOnly = true )
	public List<User> findByRuolo(Ruolo ruolo){
		return userDao.findByRuolo(ruolo);
	}
	*/
	@Override
	@Transactional(readOnly=true)
	public User findByUsername(String username){
		return userDao.findByUsername(username);	
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<User> findByPassword(String password){
		return userDao.findByPassword(password);
	}
	@Override
	@Transactional
	public void save(User user){
		userDao.save(user);
	}
	@Override
	@Transactional
	public void delete(User user){
		userDao.delete(user);	
	}
}
