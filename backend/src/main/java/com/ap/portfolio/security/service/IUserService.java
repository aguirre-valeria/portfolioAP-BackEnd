package com.ap.portfolio.security.service;

import com.ap.portfolio.model.User;
import com.ap.portfolio.security.model.UserRol;

import java.util.Set;

public interface IUserService {

    public User saveUserLogin(User user, Set<UserRol> userRols) throws Exception;

    public User saveUser(User user);

    public User getUserLogin(String username);

    public void deleteUserLogin(Long idUser);
    
}


