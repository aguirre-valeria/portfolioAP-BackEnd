package com.ap.portfolio.service;

import com.ap.portfolio.model.Project;
import com.ap.portfolio.repository.IProjectRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProjectService {
    private final IProjectRepository projectRepository;
    public ProjectService(IProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    //ENCONTRAR UNO por ID
    public Optional<Project> findProjectById(Long id) {
        return projectRepository.findById(id);
    }
    //ENCONTRAR a TODOS
    public List<Project> findProjects() {
        return projectRepository.findAll();
    }
    //AGREGAR UNO
    public Project addProject(Project project) {
        return projectRepository.save(project);
    }
    //EDITAR UNO
    public Project editProject(Project project) {
        return projectRepository.save(project);
    }
    //ELIMINAR UNO por ID
    public void removeProject(Long id) {
        projectRepository.deleteById(id);
    }
}
