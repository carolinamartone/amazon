package it.csttech.manager;

import java.util.List;

import it.csttech.model.UserRoles;

public interface UserRolesManager {
	List<UserRoles> findbyRole(String role);

	List<UserRoles> getAllUserRoles();

	UserRoles findByUsername(String username);

	UserRoles findById(int user_role_id);
	
	void save(UserRoles userRoles);
}
