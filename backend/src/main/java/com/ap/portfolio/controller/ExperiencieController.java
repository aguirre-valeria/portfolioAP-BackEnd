package com.ap.portfolio.controller;

import com.ap.portfolio.model.Experiencie;
import com.ap.portfolio.service.ExperiencieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/experiencie")
public class ExperiencieController {
    @Autowired
    private final ExperiencieService experiencieService;

    public ExperiencieController(ExperiencieService experiencieService) {
        this.experiencieService = experiencieService;
    }

    //ENCONTRAR UNO por ID
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
    }
}
