package com.ap.portfolio.repository;

import com.ap.portfolio.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserRepository extends JpaRepository<User,Long> {

    public User findByUsername(String username);
    public static List<User> findUserById(Long id) {
        return null;
    };
}
