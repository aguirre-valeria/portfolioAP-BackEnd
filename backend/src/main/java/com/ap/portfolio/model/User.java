package com.ap.portfolio.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

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
    private String email;

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

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Experiencie> experiencies;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Education> educations;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Project> projects;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Skill> skills;

    public User() {
    }

    public User(Long id, String name, String surname, String email, String titleProfession, String description, String urlPhoto, String urlBanner, String urlGitHub, String urlLinkedIn) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.titleProfession = titleProfession;
        this.description = description;
        this.urlPhoto = urlPhoto;
        this.urlBanner = urlBanner;
        this.urlGitHub = urlGitHub;
        this.urlLinkedIn = urlLinkedIn;
    }

    public User(Long id, String name, String surname, String email, String titleProfession, String description, String urlPhoto, String urlBanner, String urlGitHub, String urlLinkedIn, List<Experiencie> experiencies, List<Education> educations, List<Project> projects, List<Skill> skills) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.titleProfession = titleProfession;
        this.description = description;
        this.urlPhoto = urlPhoto;
        this.urlBanner = urlBanner;
        this.urlGitHub = urlGitHub;
        this.urlLinkedIn = urlLinkedIn;
        this.experiencies = experiencies;
        this.educations = educations;
        this.projects = projects;
        this.skills = skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
        for (Skill variablelocal : skills) {
            variablelocal.setUser(this);
        }
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
        for (Project variablelocal : projects) {
            variablelocal.setUser(this);
        }
    }

    public void setExperiencies(List<Experiencie> experiencies) {
        this.experiencies = experiencies;
        for (Experiencie variablelocal : experiencies) {
            variablelocal.setUser(this);
        }
    }

    public void setEducations(List<Education> educations) {
        this.educations = educations;
        for (Education variablelocal : educations) {
            variablelocal.setUser(this);
        }
    }

}