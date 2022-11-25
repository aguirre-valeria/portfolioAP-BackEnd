package com.ap.portfolio.controller;

import com.ap.portfolio.model.Project;
import com.ap.portfolio.model.User;
import com.ap.portfolio.service.ProjectService;
import com.ap.portfolio.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/user/{idUser}/projects")
public class ProjectController {
    @Autowired
    private final ProjectService projectService;

    @Autowired
    private final UserService userService;

    public ProjectController(ProjectService projectService, UserService userService) {
        this.projectService = projectService;
        this.userService = userService;
    }

    //ENCONTRAR UNO por ID
/*    @GetMapping("/id/{id}")
    public ResponseEntity<Project> getProjectById(@PathVariable("idUser") Long idUser, @PathVariable("id") Long id) {

        Optional<Project> project = projectService.findProjectById(id);
        return new ResponseEntity(project, HttpStatus.OK);
    }*/

    @GetMapping()
    public ResponseEntity<Collection<Project>> getProjectsByUser(@PathVariable Long idUser) {
        User user = userService.findUserById(idUser);
        return new ResponseEntity<>(user.getProjects(), HttpStatus.OK);
    }

    //ENCONTRAR a TODOS
/*    @GetMapping("/all")
    public ResponseEntity<List<Project>> getProjects() {
        List<Project> projects = projectService.findProjects();
        return new ResponseEntity<>(projects, HttpStatus.OK);
    }*/
    //AGREGAR UNO
/*    @PostMapping("/create")
    public ResponseEntity<Project> addProject(@RequestBody Project project) {
        Project newProject = projectService.addProject(project);
        return new ResponseEntity<>(newProject, HttpStatus.CREATED);
    }*/

    @PostMapping("/add")
    public Project addProject(@PathVariable Long idUser, @RequestBody Project project) {
        User user = userService.findUserById(idUser);
        user.addProject(project);
        return projectService.addProject(project);
    }
    //EDITAR UNO
/*    @PutMapping("/update")
    public ResponseEntity<Project> editProject(@PathVariable Long idUser, @RequestBody Project project) {
        User user = userService.findUserById(idUser);
        user.addProject(project);
        return new ResponseEntity<>(project, HttpStatus.OK);
    }*/
/*    @PutMapping("/update")
    public ResponseEntity<Project> editProject(@RequestBody Project project) {
        Project updateProject = projectService.editProject(project);
        return new ResponseEntity<>(updateProject, HttpStatus.OK);
    }*/
/*    @PutMapping("/update/{idProj}")
    public ResponseEntity<Project> editProject(@PathVariable Long idUser, @PathVariable Long idProj, @RequestBody Project project) {
        User user = userService.findUserById(idUser);
        user.getProject(projectService.update(idUser, idProj, project));
        return new ResponseEntity<>(project, HttpStatus.OK);
    }*/

    @PutMapping("/update/{idProj}")
    public Project updateProject(@PathVariable Long idUser, @PathVariable("idProj") Long idProj, @RequestBody Project project) {
        User user = userService.findUserById(idUser);
        user.addProject(project);
        projectService.removeProject(idProj);
        return projectService.addProject(project);
    }

    //ELIMINAR UNO por ID
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Long> deleteProject(@PathVariable Long idUser, @PathVariable("id") Long id) {
        User user = userService.findUserById(idUser);
        projectService.removeProject(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
