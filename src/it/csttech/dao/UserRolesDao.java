package it.csttech.dao;

import java.util.List;

import it.csttech.model.UserRoles;

public interface UserRolesDao {
	List<UserRoles> findbyRole(String role);

	List<UserRoles> getAllUserRoles();

	UserRoles findByUsername(String username);

	UserRoles findById(int userRoleId);
}
