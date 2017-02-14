package it.csttech.manager;

import java.util.List;

import it.csttech.model.UserRoles;


public interface UserRolesManager extends BaseManager<UserRoles>
{
    List<UserRoles> findbyRole(String role);

    UserRoles findByUsername(String username);
    
    void insert (UserRoles userRoles);

}
