package com.ap.portfolio.security.controller;

import com.ap.portfolio.model.User;
import com.ap.portfolio.security.model.Rol;
import com.ap.portfolio.security.model.UserRol;
import com.ap.portfolio.security.service.IUserService;
import com.ap.portfolio.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/users")
public class UserLoginController {

    @Autowired
    private IUserService userLoginService;

    @Autowired
    private UserService userService;



   @PostMapping("/")
    public User saveUserLogin(@RequestBody User userLogin) throws Exception {
        Set<UserRol> userRoles = new HashSet<>();

        Rol rol = new Rol();
        rol.setIdRol(2L);
        rol.setNameRol("NORMAL");

        UserRol userRol = new UserRol();
        userRol.setUser(userLogin);
        userRol.setRol(rol);

        userRoles.add(userRol);
        return userLoginService.saveUserLogin(userLogin, userRoles);
    }

    @PutMapping("/up")
    public ResponseEntity<User> upUser(@RequestBody User user) {
        User updateUser = userLoginService.saveUser(user);
        return new ResponseEntity<>(updateUser, HttpStatus.OK);
    }

    @GetMapping("/{username}")
    public User getUserLogin(@PathVariable("username") String username) {
        return userLoginService.getUserLogin(username);
    }

    @DeleteMapping("/{idUser}")
    public void deleteUserLogin(@PathVariable("idUser") Long idUser) {
        userLoginService.deleteUserLogin(idUser);
    }

    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User newUser = userService.addUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }
}
