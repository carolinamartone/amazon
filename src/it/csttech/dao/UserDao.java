
package it.csttech.dao;

import java.util.List;

import it.csttech.model.User;


public interface UserDao extends BaseDao<User>
{

    User findByUsername(String username);

    List<User> findByPassword(String password);

}
