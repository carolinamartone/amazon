package it.csttech.manager;

import java.util.List;

import it.csttech.model.Role;

public interface RoleManager {
	Role findById(Long id);

	List<Role> getAllRoles();

}
