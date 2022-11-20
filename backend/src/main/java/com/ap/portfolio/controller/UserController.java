package com.ap.portfolio.controller;

import com.ap.portfolio.model.Skill;
import com.ap.portfolio.model.User;
import com.ap.portfolio.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
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
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id) {
        User user = userService.findUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    //ENCONTRAR a TODOS
    @GetMapping("/all")
    public ResponseEntity<List<User>> getUsers() {
        List<User> users = userService.findUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
    //AGREGAR UNO
    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User newUser = userService.addUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    //EDITAR UNO
/*    @PutMapping("/update")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        User updateUser = userService.editUser(user);
        return new ResponseEntity<>(updateUser, HttpStatus.OK);
    }*/

    @PutMapping("/update/{idUser}")
    public ResponseEntity<User> updateUser(@PathVariable Long idUser, @RequestBody User user) {
        User editUser = userService.findUserById(idUser);
        if(editUser == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        try {
            editUser.setName(user.getName());
            editUser.setSurname(user.getSurname());
            editUser.setEmail(user.getEmail());
            editUser.setTitleProfession(user.getTitleProfession());
            editUser.setDescription(user.getDescription());
            editUser.setUrlPhoto(user.getUrlPhoto());
            editUser.setUrlBanner(user.getUrlBanner());
            editUser.setUrlGitHub(user.getUrlGitHub());
            editUser.setUrlLinkedIn(user.getUrlLinkedIn());
            return new ResponseEntity<>(userService.update(editUser), HttpStatus.OK);
        } catch (DataAccessException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    //ELIMINAR UNO por ID
    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.removeUser(id);
        return "El usuario fue eliminado correctamente";
    }
}

