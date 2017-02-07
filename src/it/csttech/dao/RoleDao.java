package it.csttech.dao;

import java.util.List;

import it.csttech.model.Role;

public interface RoleDao {
	Role findById(Long id);

	List<Role> getAllRoles();

}
