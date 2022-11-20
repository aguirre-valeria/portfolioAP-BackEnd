package com.ap.portfolio.controller;

import com.ap.portfolio.model.Project;
import com.ap.portfolio.model.Skill;
import com.ap.portfolio.model.User;
import com.ap.portfolio.service.SkillService;
import com.ap.portfolio.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/user/{idUser}/skills")
public class SkillController {
    @Autowired
    private final SkillService skillService;

    @Autowired
    private final UserService userService;

    public SkillController(SkillService skillService, UserService userService) {
        this.skillService = skillService;
        this.userService = userService;
    }

    @GetMapping()
    public ResponseEntity<Collection<Skill>> getSkillsByUser(@PathVariable Long idUser) {
        User user = userService.findUserById(idUser);
        return new ResponseEntity<>(user.getSkills(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public Skill addSkill(@PathVariable Long idUser, @RequestBody Skill skill) {
        User user = userService.findUserById(idUser);
        user.addSkill(skill);
        return skillService.addSkill(skill);
    }

    @PutMapping("/update/{idSkill}")
    public Skill updateSkill(@PathVariable Long idUser, @PathVariable("idSkill") Long idSkill, @RequestBody Skill skill) {
        User user = userService.findUserById(idUser);
        user.addSkill(skill);
        skillService.removeSkill(idSkill);
        return skillService.addSkill(skill);
    }

    @DeleteMapping("delete/{id}")
    public String deleteSkill(@PathVariable("id") Long id) {
        skillService.removeSkill(id);
        return "La Skill fue eliminada correctamente";
    }

/*    //ENCONTRAR UNO por ID
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
    }*/


    //PRUEBA

}
