package com.ap.portfolio.service;

import com.ap.portfolio.model.Project;
import com.ap.portfolio.repository.IProjectRepository;
import com.ap.portfolio.repository.IUserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProjectService {
    private final IProjectRepository projectRepository;
    private final IUserRepository userRepository;
    public ProjectService(IProjectRepository projectRepository, IUserRepository userRepository) {
        this.projectRepository = projectRepository;
        this.userRepository = userRepository;
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

    public Optional<Project> update(Long idUser, Long id, Project project) {
        // Only update an item if it can be found first.
        return projectRepository.findById(id)
                .map(oldItem -> {
                    Project updated = oldItem.updateWith(idUser, project);
                    return projectRepository.save(updated);
                });
    }
    //ELIMINAR UNO por ID
    public void removeProject(Long id) {
        projectRepository.deleteById(id);
    }
}
