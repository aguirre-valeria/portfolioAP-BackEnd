package com.ap.portfolio.controller;

import com.ap.portfolio.model.Skill;
import com.ap.portfolio.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/skill")
public class SkillController {
    @Autowired
    private final SkillService skillService;

    public SkillController(SkillService skillService) {
        this.skillService = skillService;
    }

    //ENCONTRAR UNO por ID
    @GetMapping("/id/{id}")
    public ResponseEntity<Skill> getSkillById(@PathVariable("id") Long id) {
        Skill skill = skillService.findSkillById(id).get();
        return new ResponseEntity(skill, HttpStatus.OK);
    }
    //ENCONTRAR a TODOS
    @GetMapping("/all")
    public ResponseEntity<List<Skill>> getSkills() {
        List<Skill> skills = skillService.findSkills();
        return new ResponseEntity<>(skills, HttpStatus.OK);
    }
    //AGREGAR UNO
    @PostMapping("/create")
    public ResponseEntity<Skill> createSkill(@RequestBody Skill skill) {
        Skill newSkill = skillService.addSkill(skill);
        return new ResponseEntity<>(newSkill, HttpStatus.CREATED);
    }
    //EDITAR UNO
    @PutMapping("/update")
    public ResponseEntity<Skill> updateSkill(@RequestBody Skill skill) {
        Skill updateSkill = skillService.editSkill(skill);
        return new ResponseEntity<>(updateSkill, HttpStatus.OK);
    }
    //ELIMINAR UNO por ID
    @DeleteMapping("/delete/{id}")
    public String deleteSkill(@PathVariable Long id) {
        skillService.removeSkill(id);
        return "El skill fue eliminado correctamente";
    }


    //PRUEBA

}
