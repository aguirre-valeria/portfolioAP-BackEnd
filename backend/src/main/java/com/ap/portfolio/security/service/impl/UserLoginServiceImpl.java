package com.ap.portfolio.security.service.impl;

import com.ap.portfolio.security.model.UserLogin;
import com.ap.portfolio.security.model.UserRol;
import com.ap.portfolio.security.repository.IRolRepository;
import com.ap.portfolio.security.repository.IUserLoginRepository;
import com.ap.portfolio.security.service.IUserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserLoginServiceImpl implements IUserLoginService {

    @Autowired
    private IUserLoginRepository userLoginRepository;

    @Autowired
    private IRolRepository rolRepository;

    @Override
    public UserLogin saveUserLogin(UserLogin userLogin, Set<UserRol> userRols) throws Exception {
        UserLogin userLocal = userLoginRepository.findByUsername(userLogin.getUsername());
        if(userLocal != null){
            System.out.println("El usuario ya existe");
            throw new Exception("El usuario ya está presente");
        }
        else{
            for(UserRol userRol:userRols){
                rolRepository.save(userRol.getRol());
            }
            userLogin.getUserRols().addAll(userRols);
            userLocal = userLoginRepository.save(userLogin);
        }
        return userLocal;
    }

    @Override
    public UserLogin getUserLogin(String username) {
        return userLoginRepository.findByUsername(username);
    }

    @Override
    public void deleteUserLogin(Long idUser) {
        userLoginRepository.deleteById(idUser);
    }

}
