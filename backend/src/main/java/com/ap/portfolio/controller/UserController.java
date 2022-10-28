package com.ap.portfolio.controller;

import com.ap.portfolio.model.User;
import com.ap.portfolio.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //ENCONTRAR UNO por ID
    @GetMapping("/id/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id) {
        User user = userService.findUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    //ENCONTRAR a TODOS
    @GetMapping("/all")
    public List<User> getUsers() {
        return userService.findUsers();
    }
    //AGREGAR UNO
    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User newUser = userService.addUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }
    //EDITAR UNO
    @PutMapping("/update")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        User updateUser = userService.editUser(user);
        return new ResponseEntity<>(updateUser, HttpStatus.OK);
    }
    //ELIMINAR UNO por ID
    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.removeUser(id);
        return "El usuario fue eliminado correctamente";
    }
}

