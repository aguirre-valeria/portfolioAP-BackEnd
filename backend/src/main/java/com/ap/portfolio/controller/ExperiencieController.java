package com.ap.portfolio.controller;

import com.ap.portfolio.model.Experiencie;
import com.ap.portfolio.model.Project;
import com.ap.portfolio.model.User;
import com.ap.portfolio.service.ExperiencieService;
import com.ap.portfolio.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/user/{idUser}/experiencies")
public class ExperiencieController {
    @Autowired
    private final ExperiencieService experiencieService;

    @Autowired
    private final UserService userService;

    public ExperiencieController(ExperiencieService experiencieService, UserService userService) {
        this.experiencieService = experiencieService;
        this.userService = userService;
    }

    @GetMapping()
    public ResponseEntity<Collection<Experiencie>> getExperienciesByUser(@PathVariable Long idUser) {
        User user = userService.findUserById(idUser);
        return new ResponseEntity<>(user.getExperiencies(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public Experiencie addExperiencie(@PathVariable Long idUser, @RequestBody Experiencie experiencie) {
        User user = userService.findUserById(idUser);
        user.addExperiencie(experiencie);
        return experiencieService.addExperiencie(experiencie);
    }

    @PutMapping("/update/{idExp}")
    public Experiencie updateExperiencie(@PathVariable Long idUser, @PathVariable("idExp") Long idExp, @RequestBody Experiencie experiencie) {
        User user = userService.findUserById(idUser);
        user.addExperiencie(experiencie);
        experiencieService.removeExperiencie(idExp);
        return experiencieService.addExperiencie(experiencie);
    }

    //ELIMINAR UNO por ID
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Long> deleteExperiencie(@PathVariable Long idUser, @PathVariable("id") Long id) {
        User user = userService.findUserById(idUser);
        experiencieService.removeExperiencie(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

/*    //ENCONTRAR UNO por ID
    @GetMapping("/id/{id}")
    public ResponseEntity<Experiencie> getExperiencie(@PathVariable("id") Long id) {
        Experiencie experiencie = experiencieService.findExperiencieById(id).get();
        return new ResponseEntity(experiencie, HttpStatus.OK);
    }
    //ENCONTRAR a TODOS
    @GetMapping("/all")
    public ResponseEntity<List<Experiencie>> getExperiencies() {
        List<Experiencie> experiencies = experiencieService.findExperiencies();
        return new ResponseEntity<>(experiencies, HttpStatus.OK);
    }
    //AGREGAR UNO
    @PostMapping("/create")
    public ResponseEntity<Experiencie> addExperiencie(@RequestBody Experiencie experiencie) {
        Experiencie newExperiencie = experiencieService.addExperiencie(experiencie);
        return new ResponseEntity<>(newExperiencie, HttpStatus.CREATED);
    }
    //EDITAR UNO
    @PutMapping("/update")
    public ResponseEntity<Experiencie> editExperiencie(@RequestBody Experiencie experiencie) {
        Experiencie editExperiencie = experiencieService.editExperiencie(experiencie);
        return new ResponseEntity<>(editExperiencie, HttpStatus.OK);
    }
    //ELIMINAR UNO por ID
    @DeleteMapping("delete/{id}")
    public String deleteExperiencie(@PathVariable("id") Long id) {
        experiencieService.removeExperiencie(id);
        return "La experiencia fue eliminada correctamente";
    }*/
}
