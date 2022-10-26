package com.ap.portfolio.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSkill;
    private String nameSkill;
    private String porcentageSkill;

    public Skill() {
    }

    public Skill(Long idSkill, String nameSkill, String porcentageSkill) {
        this.idSkill = idSkill;
        this.nameSkill = nameSkill;
        this.porcentageSkill = porcentageSkill;
    }
}
