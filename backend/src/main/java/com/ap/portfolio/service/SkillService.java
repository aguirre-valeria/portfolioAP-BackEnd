package com.ap.portfolio.service;

import com.ap.portfolio.model.Skill;
import com.ap.portfolio.model.User;
import com.ap.portfolio.repository.ISkillRepository;
import com.ap.portfolio.repository.IUserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SkillService {
    private final ISkillRepository skillRepository;

    public SkillService(ISkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    //ENCONTRAR UNO por ID
    public Optional<Skill> findSkillById(Long id) {
        return skillRepository.findById(id);
    }
    //ENCONTRAR a TODOS
    public List<Skill> findSkills() {
        return skillRepository.findAll();
    }
    //AGREGAR UNO
    public Skill createSkill(Skill skill, User user) {
        Long userId = user.getId();
        Skill createSkill = new Skill();
        user = IUserRepository.findUserById(userId);

        createSkill.setIdSkill(skill.getIdSkill());
        createSkill.setNameSkill(skill.getNameSkill());
        createSkill.setPorcentageSkill(skill.getPorcentageSkill());
        createSkill.setUser(user);
        return skillRepository.save(createSkill);
    }
    //EDITAR UNO
    public Skill editSkill(Skill skill) {
        return skillRepository.save(skill);
    }
    //ELIMINAR UNO por ID
    public void removeSkill(Long id) {
        skillRepository.deleteById(id);
    }

    public boolean existsById(Long id) {
        return skillRepository.existsById(id);
    }
}
