package com.ap.portfolio.controller;

import com.ap.portfolio.model.Education;
import com.ap.portfolio.model.Project;
import com.ap.portfolio.model.User;
import com.ap.portfolio.service.EducationService;
import com.ap.portfolio.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/user/{idUser}/educations")
public class EducationController {
    @Autowired
    private final EducationService educationService;

    @Autowired
    private final UserService userService;

    public EducationController(EducationService educationService, UserService userService) {
        this.educationService = educationService;
        this.userService = userService;
    }

    @GetMapping()
    public ResponseEntity<Collection<Education>> getEducationsByUser(@PathVariable Long idUser) {
        User user = userService.findUserById(idUser);
        return new ResponseEntity<>(user.getEducations(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public Education addEducation(@PathVariable Long idUser, @RequestBody Education education) {
        User user = userService.findUserById(idUser);
        user.addEducation(education);
        return educationService.addEducation(education);
    }

    @PutMapping("/update/{idEdu}")
    public Education updateEducation(@PathVariable Long idUser, @PathVariable("idEdu") Long idEdu, @RequestBody Education education) {
        User user = userService.findUserById(idUser);
        user.addEducation(education);
        educationService.removeEducation(idEdu);
        return educationService.addEducation(education);
    }

    @DeleteMapping("delete/{id}")
    public String deleteEducation(@PathVariable("id") Long id) {
        educationService.removeEducation(id);
        return "La educación fue eliminada correctamente";
    }



/*
    //ENCONTRAR UNO por ID
    @GetMapping("/id/{id}")
    public ResponseEntity<Education> getEducationById(@PathVariable("id") Long id) {
        Education education = educationService.findEducationById(id).get();
        return new ResponseEntity(education, HttpStatus.OK);
    }
    //ENCONTRAR a TODOS
    @GetMapping("/all")
    public ResponseEntity<List<Education>> getEducations() {
        List<Education> educations = educationService.findEducations();
        return new ResponseEntity<>(educations, HttpStatus.OK);
    }
    //AGREGAR UNO
    @PostMapping("/create")
    public ResponseEntity<Education> addEducation(@RequestBody Education education) {
        Education newEducation = educationService.addEducation(education);
        return new ResponseEntity<>(newEducation, HttpStatus.CREATED);
    }
    //EDITAR UNO
    @PutMapping("/update")
    public ResponseEntity<Education> editEducation(@RequestBody Education education) {
        Education editEducation = educationService.editEducation(education);
        return new ResponseEntity<>(editEducation, HttpStatus.OK);
    }
    //ELIMINAR UNO por ID
    @DeleteMapping("delete/{id}")
        public String deleteEducation(@PathVariable("id") Long id) {
        educationService.removeEducation(id);
        return "La educación fue eliminada correctamente";
    }
*/

}
