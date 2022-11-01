package com.ap.portfolio.controller;

import com.ap.portfolio.model.Education;
import com.ap.portfolio.service.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/education")
public class EducationController {
    @Autowired
    private final EducationService educationService;

    public EducationController(EducationService educationService) {
        this.educationService = educationService;
    }

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

}
