package com.ap.portfolio.service;

import com.ap.portfolio.model.Experiencie;
import com.ap.portfolio.model.Project;
import com.ap.portfolio.repository.IExperiencieRepository;
import com.ap.portfolio.repository.IProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ExperiencieService {
    private final IExperiencieRepository experiencieRepository;

    public ExperiencieService(IExperiencieRepository experiencieRepository) {
        this.experiencieRepository = experiencieRepository;
    }

    //ENCONTRAR UNO por ID
    public Optional<Experiencie> findExperiencieById(Long id) {
        return experiencieRepository.findById(id);
    }
    //ENCONTRAR a TODOS
    public List<Experiencie> findExperiencies() {
        return experiencieRepository.findAll();
    }
    //AGREGAR UNO
    public Experiencie addExperiencie(Experiencie experiencie) {
        return experiencieRepository.save(experiencie);
    }
    //EDITAR UNO
    public Experiencie editExperiencie(Experiencie experiencie) {
        return experiencieRepository.save(experiencie);
    }
    //ELIMINAR UNO por ID
    public void removeExperiencie(Long id) {
        experiencieRepository.deleteById(id);
    }
}
