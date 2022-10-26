package com.ap.portfolio.service;

import com.ap.portfolio.model.Experiencie;
import com.ap.portfolio.repository.IExperiencieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ExperiencieService {
    private final IExperiencieRepository experiencieRepository;

    @Autowired
    public ExperiencieService(IExperiencieRepository experiencieRepository) {
        this.experiencieRepository = experiencieRepository;
    }

    public Experiencie addExperiencie(Experiencie experiencie) {
        return experiencieRepository.save(experiencie);
    }

    public List<Experiencie> findExperiencies() {
        return experiencieRepository.findAll();
    }

    public Experiencie editExperiencie(Experiencie experiencie) {
        return experiencieRepository.save(experiencie);
    }

    public void deleteExperiencie(Long id) {
        experiencieRepository.deleteById(id);
    }
}
