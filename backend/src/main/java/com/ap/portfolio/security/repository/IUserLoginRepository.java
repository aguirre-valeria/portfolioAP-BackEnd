package com.ap.portfolio.security.repository;

import com.ap.portfolio.security.model.UserLogin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserLoginRepository extends JpaRepository<UserLogin, Long> {

    public UserLogin findByUsername(String username);
}
