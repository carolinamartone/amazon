package it.csttech.manager;

import java.util.List;

import it.csttech.model.User;


public interface UserManager extends BaseManager<User>
{

    User findByUsername(String username);

    List<User> findByPassword(String password);
    
    void insert(User user);
    
}
