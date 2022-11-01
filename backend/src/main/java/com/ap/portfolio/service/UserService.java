package com.ap.portfolio.service;

import com.ap.portfolio.model.User;
import com.ap.portfolio.repository.IUserRepository;
import com.ap.portfolio.exception.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {
    private final IUserRepository userRepository;

    public UserService(IUserRepository userRepository) {

        this.userRepository = userRepository;
    }

    //ENCONTRAR UNO por ID
    public User findUserById(Long id) {
        return (User) userRepository.findById(id).orElseThrow(() -> new UserException("Usuario no encontrado"));
    }
    //ENCONTRAR a TODOS
    public List<User> findUsers() {
        return userRepository.findAll();
    }
    //AGREGAR UNO
    public User addUser(User user) {
        return userRepository.save(user);
    }
    //EDITAR UNO
    public User editUser(User user) {
        return userRepository.save(user);
    }
    //ELIMINAR UNO por ID
    public void removeUser(Long id) {
        userRepository.deleteById(id);
    }
}
