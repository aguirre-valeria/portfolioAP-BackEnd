package com.ap.portfolio.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Getter @Setter
@Entity
@Table(name = "skill")
public class Skill implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSkill;
    @NotNull
    @Size(min = 1, max = 45, message = "No cumple con la longitud")
    private String nameSkill;
    @NotNull
    private int porcentageSkill;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="user_id", nullable=false, updatable = false)
    @JsonProperty(access = Access.WRITE_ONLY)
    private User user;

    public Skill() {
    }

    public Skill(Long idSkill, String nameSkill, int porcentageSkill) {
        this.idSkill = idSkill;
        this.nameSkill = nameSkill;
        this.porcentageSkill = porcentageSkill;
    }
}
