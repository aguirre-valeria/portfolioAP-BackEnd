package com.ap.portfolio.security.service;

import com.ap.portfolio.security.model.UserLogin;
import com.ap.portfolio.security.model.UserRol;

import java.util.Set;

public interface IUserLoginService {

    public UserLogin saveUserLogin(UserLogin userLogin, Set<UserRol> userRols) throws Exception;

    public UserLogin getUserLogin(String username);

    public void deleteUserLogin(Long idUser);
    
}


