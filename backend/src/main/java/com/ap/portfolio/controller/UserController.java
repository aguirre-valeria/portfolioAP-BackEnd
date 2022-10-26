package com.ap.portfolio.controller;

import com.ap.portfolio.model.User;
import com.ap.portfolio.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {

        this.userService = userService;
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") Long id) {
        User user = userService.findUser(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/all")
    public List<User> getUsers() {
        return userService.findUsers();
    }

    @PutMapping("/update")
    public ResponseEntity<User> editUser(@RequestBody User user) {
        User updateUser = userService.editUser(user);
        return new ResponseEntity<>(updateUser, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "El usuario fue eliminado correctamente";
    }
}

