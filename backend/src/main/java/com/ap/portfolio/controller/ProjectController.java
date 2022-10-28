package com.ap.portfolio.controller;

import com.ap.portfolio.model.Project;
import com.ap.portfolio.model.Skill;
import com.ap.portfolio.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project")
public class ProjectController {
    @Autowired
    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    //ENCONTRAR UNO por ID
    @GetMapping("/id/{id}")
    public ResponseEntity<Project> getProjectById(@PathVariable("id") Long id) {
        Project project = projectService.findProjectById(id).get();
        return new ResponseEntity(project, HttpStatus.OK);
    }
    //ENCONTRAR a TODOS
    // @GetMapping("/all")
    // public ResponseEntity<List<Project>> getAllProjects() {
    //    List<Project> projects = projectService.findAllProjects();
    //    return new ResponseEntity<>(projects, HttpStatus.OK);
    //}

    //ENCONTRAR a TODOS
    @GetMapping("/all")
    public ResponseEntity<List<Project>> getProjects() {
        List<Project> projects = projectService.findProjects();
        return new ResponseEntity<>(projects, HttpStatus.OK);
    }
    //AGREGAR UNO
    @PostMapping("/create")
    public ResponseEntity<Project> addProject(@RequestBody Project project) {
        Project newProject = projectService.addProject(project);
        return new ResponseEntity<>(newProject, HttpStatus.CREATED);
    }
    //EDITAR UNO
    @PutMapping("/update")
    public ResponseEntity<Project> editProject(@RequestBody Project project) {
        Project editProject = projectService.editProject(project);
        return new ResponseEntity<>(editProject, HttpStatus.OK);
    }
    //ELIMINAR UNO por ID
    @DeleteMapping("delete/{id}")
    public String deleteProject(@PathVariable("id") Long id) {
        projectService.removeProject(id);
        return "El usuario fue eliminado correctamente";
    }
}
