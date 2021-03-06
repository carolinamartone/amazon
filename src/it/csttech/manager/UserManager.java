package it.csttech.manager;

import java.util.List;


import it.csttech.model.User;

public interface UserManager {
	User findById(int id);
	List<User>getAllUsers();
	//List<User> findByRuolo(Ruolo ruolo);
	User findByUsername(String username);
	List<User> findByPassword(String password);
	void save(User user); 
	void delete(User user);
}
