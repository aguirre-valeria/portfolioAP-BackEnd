package com.ap.portfolio.repository;

import com.ap.portfolio.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User,Long> {

    static User findUserById(Long id) {
        return null;
    }
}