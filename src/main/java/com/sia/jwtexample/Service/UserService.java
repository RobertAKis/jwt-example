package com.sia.jwtexample.Service;

import com.sia.jwtexample.domain.Role;
import com.sia.jwtexample.domain.User;
import org.springframework.stereotype.Service;


import java.util.List;

public interface UserService {
    User saveUser (User user);
    Role saveRole (Role role);
    void addRole (String username, String roleName);
    User getUser (String username);
    List<User> getUsers();
}
