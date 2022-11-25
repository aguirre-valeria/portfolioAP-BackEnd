package com.ap.portfolio.security.service.impl;

import com.ap.portfolio.model.User;
import com.ap.portfolio.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private IUserRepository userLoginRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User userLogin = this.userLoginRepository.findByUsername(username);
        if(userLogin == null){
            throw new UsernameNotFoundException("Usuario no encontrado");
        }
        return userLogin;
    }
}
