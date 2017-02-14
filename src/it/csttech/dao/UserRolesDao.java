package it.csttech.dao;

import java.util.List;

import it.csttech.model.UserRoles;


public interface UserRolesDao extends BaseDao<UserRoles>
{
    List<UserRoles> findbyRole(String role);

    UserRoles findByUsername(String username);

}
