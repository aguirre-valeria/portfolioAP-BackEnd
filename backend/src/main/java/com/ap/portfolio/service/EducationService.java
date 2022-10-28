package com.ap.portfolio.service;

import com.ap.portfolio.model.Education;
import com.ap.portfolio.model.User;
import com.ap.portfolio.repository.IEducationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EducationService {
    private final IEducationRepository educationRepository;

    @Autowired
    public EducationService(IEducationRepository educationRepository) {
        this.educationRepository = educationRepository;
    }
    //ENCONTRAR UNO por ID
    public Optional<Education> findEducationById(Long id) {
        return educationRepository.findById(id);
    }
    //ENCONTRAR a TODOS
    public List<Education> findEducations() {
        return educationRepository.findAll();
    }
    //AGREGAR UNO
    public Education addEducation(Education education) {
        return educationRepository.save(education);
    }
    //EDITAR UNO
    public Education editEducation(Education education) {
        return educationRepository.save(education);
    }
    //ELIMINAR UNO por ID
    public void removeEducation(Long id) {
        educationRepository.deleteById(id);
    }
}
