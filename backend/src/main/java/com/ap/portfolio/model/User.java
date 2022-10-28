package com.ap.portfolio.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter @Setter
@Entity
@Table(name = "user")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    @Size(min = 1, max = 45, message = "No cumple con la longitud")
    private String name;

    @NotNull
    @Size(min = 1, max = 45, message = "No cumple con la longitud")
    private String surname;

    @NotNull
    @Size(min = 1, max = 45, message = "No cumple con la longitud")
    private String titleProfession;

    @NotNull
    @Size(min = 1, max = 255, message = "No cumple con la longitud")
    private String description;
    @NotNull
    @Size(min = 1, max = 255, message = "No cumple con la longitud")
    private String urlPhoto;
    @Size(min = 1, max = 255, message = "No cumple con la longitud")
    private String urlBanner;
    @Size(min = 1, max = 255, message = "No cumple con la longitud")
    private String urlGitHub;
    @Size(min = 1, max = 255, message = "No cumple con la longitud")
    private String urlLinkedIn;

    // @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "idExp")
    // private List<Experiencie> experiencieList;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Experiencie> experiencie = new HashSet<>();
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Education> education = new HashSet<>();
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Project> projects = new HashSet<>();
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @Setter(AccessLevel.NONE)
    private Set<Skill> skills = new HashSet<>();

    public User() {
    }

    public User(Long id, String name, String surname, String titleProfession, String urlPhoto, String urlBanner, String urlGitHub, String urlLinkedIn) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.titleProfession = titleProfession;
        this.urlPhoto = urlPhoto;
        this.urlBanner = urlBanner;
        this.urlGitHub = urlGitHub;
        this.urlLinkedIn = urlLinkedIn;
    }

    public void setSkills(Set<Skill> skills) {
        this.skills = skills;
        for (Skill variablelocal : skills) {
            variablelocal.setUser(this);
        }
    }

}