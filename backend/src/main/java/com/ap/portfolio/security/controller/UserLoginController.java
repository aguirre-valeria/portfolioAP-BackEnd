package com.ap.portfolio.security.controller;

import com.ap.portfolio.model.User;
import com.ap.portfolio.repository.IUserRepository;
import com.ap.portfolio.security.model.Rol;
import com.ap.portfolio.security.model.UserRol;
import com.ap.portfolio.security.service.IUserService;
import com.ap.portfolio.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/users")
public class UserLoginController {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    IUserService userLoginService;

    @Autowired
    IUserRepository userRepository;

    @Autowired
    UserService userService;

    public UserLoginController(PasswordEncoder passwordEncoder, IUserService userLoginService, UserService userService, IUserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userLoginService = userLoginService;
        this.userService = userService;
        this.userRepository = userRepository;
    }

   @PostMapping("/")
    public User saveUserLogin(@RequestBody User userLogin) throws Exception {
       User user = new User();
       user.setUsername(userLogin.getUsername());
       user.setEmail(userLogin.getEmail());
       user.setPassword(passwordEncoder.encode(userLogin.getPassword()));

       System.out.println(user);
        Set<UserRol> userRoles = new HashSet<>();

        Rol rol = new Rol();
        rol.setIdRol(1L);
        rol.setNameRol("ADMIN");

        UserRol userRol = new UserRol();
        userRol.setUser(user);
        userRol.setRol(rol);

        userRoles.add(userRol);
        return userLoginService.saveUserLogin(user, userRoles);
    }

    @PutMapping("/up")
    public ResponseEntity<User> upUser(@RequestBody User user) {
        User updateUser = userLoginService.saveUser(user);
        return new ResponseEntity<>(updateUser, HttpStatus.OK);
    }

    @GetMapping("/get/{username}")
    public User getUserLogin(@PathVariable("username") String username) {
        return userRepository.findByUsername(username);
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
