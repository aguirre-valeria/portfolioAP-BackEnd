package com.ap.portfolio.service;

import com.ap.portfolio.model.User;
import com.ap.portfolio.repository.IUserRepository;
import com.ap.portfolio.exception.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

@Service
@Transactional
public class UserService {
    private final IUserRepository userRepository;

    @Autowired
    public UserService(IUserRepository userRepository) {

        this.userRepository = userRepository;
    }

    public User addUser(User user) {

        return userRepository.save(user);
    }

    public List<User> findUsers() {

        return userRepository.findAll();
    }

    public User editUser(User user) {

        return userRepository.save(user);
    }

    public void deleteUser(Long id) {

        userRepository.deleteById(id);
    }

    public User findUser(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new UserException("Usuario no encontrado"));
    }
}
