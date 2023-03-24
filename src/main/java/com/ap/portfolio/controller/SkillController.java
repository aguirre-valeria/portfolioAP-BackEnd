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
    public ResponseEntity<Long> deleteSkill(@PathVariable Long idUser, @PathVariable("id") Long id) {
        User user = userService.findUserById(idUser);
        skillService.removeSkill(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

}
