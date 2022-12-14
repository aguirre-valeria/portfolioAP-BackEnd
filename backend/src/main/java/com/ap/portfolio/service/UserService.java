package com.ap.portfolio.service;

import com.ap.portfolio.model.Project;
import com.ap.portfolio.model.User;
import com.ap.portfolio.repository.IUserRepository;
import com.ap.portfolio.exception.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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

    //ENCONTRAR POR USUARIO
    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username);
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
    public User update(User user) {
        return userRepository.save(user);
    }

    //ELIMINAR UNO por ID
    public void removeUser(Long id) {
        userRepository.deleteById(id);
    }
}
