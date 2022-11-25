package com.ap.portfolio.security.service.impl;

import com.ap.portfolio.model.User;
import com.ap.portfolio.repository.IUserRepository;
import com.ap.portfolio.security.model.UserRol;
import com.ap.portfolio.security.repository.IRolRepository;
import com.ap.portfolio.security.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IRolRepository rolRepository;

    @Override
    public User saveUserLogin(User userLogin, Set<UserRol> userRols) throws Exception {
        User userLocal = userRepository.findByUsername(userLogin.getUsername());
        if(userLocal != null){
            System.out.println("El usuario ya existe");
            throw new Exception("El usuario ya está presente");
        }
        else{
            for(UserRol userRol:userRols){
                rolRepository.save(userRol.getRol());
            }
            userLogin.getUserRols().addAll(userRols);
            userLocal = userRepository.save(userLogin);
        }
        return userLocal;
    }

    @Override
    public User saveUser(User user) {
        User userL = userRepository.findByUsername(user.getUsername());
        if(userL != null){
            userRepository.save(user);
        }
        else{
            System.out.println("NO SE PUEDE");
        }
        return userL;
    }

    @Override
    public User getUserLogin(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public void deleteUserLogin(Long idUser) {
        userRepository.deleteById(idUser);
    }

}
