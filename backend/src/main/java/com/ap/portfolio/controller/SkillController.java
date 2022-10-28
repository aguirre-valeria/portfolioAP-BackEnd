package com.ap.portfolio.controller;

import com.ap.portfolio.model.Skill;
import com.ap.portfolio.model.User;
import com.ap.portfolio.repository.IUserRepository;
import com.ap.portfolio.service.SkillService;
import com.ap.portfolio.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

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
        if (!skillService.existsById(id)) {
            return new ResponseEntity(ResponseEntity.internalServerError(), HttpStatus.NOT_FOUND);
        }
        Skill skill = skillService.findSkillById(id).get();
        return new ResponseEntity(skill, HttpStatus.OK);
    }
    //ENCONTRAR a TODOS
    @GetMapping("/all")
    public List<Skill> getSkills() {
        return skillService.findSkills();
    }
    //AGREGAR UNO
    @PostMapping("/create")
    public Skill createSkill(@RequestBody Skill skill, User user) {

        return skillService.createSkill(skill, user);
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


}
