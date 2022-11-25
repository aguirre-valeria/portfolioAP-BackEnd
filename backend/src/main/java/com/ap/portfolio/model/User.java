package com.ap.portfolio.model;

import com.ap.portfolio.security.model.Authority;
import com.ap.portfolio.security.model.UserRol;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.*;

@Getter @Setter
@Entity
@Table(name = "user")
public class User implements Serializable, UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String username;
    private String password;
    private boolean enabled = true;
    @Size(min = 1, max = 45, message = "No cumple con la longitud")
    private String name;

    @Size(min = 1, max = 45, message = "No cumple con la longitud")
    private String surname;

    @NotNull
    private String email;

    @Size(min = 1, max = 45, message = "No cumple con la longitud")
    private String titleProfession;

    @Size(min = 1, max = 255, message = "No cumple con la longitud")
    private String description;
    @Size(min = 1, max = 255, message = "No cumple con la longitud")
    private String urlPhoto;
    @Size(min = 1, max = 255, message = "No cumple con la longitud")
    private String urlBanner;
    @Size(min = 1, max = 255, message = "No cumple con la longitud")
    private String urlGitHub;
    @Size(min = 1, max = 255, message = "No cumple con la longitud")
    private String urlLinkedIn;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "user")
    @JsonIgnore
    private Set<UserRol> userRols = new HashSet<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Experiencie> experiencies;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Education> educations;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Project> projects;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Skill> skills;

    public User(String username, String email, String password) {
    }

    public User() {
    }

    public User(Long id, String username, String password, boolean enabled, String name, String surname, String email, String titleProfession, String description, String urlPhoto, String urlBanner, String urlGitHub, String urlLinkedIn) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.enabled = enabled;
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

    public User(Long id, String name, String surname, String email, String titleProfession, String description, String urlPhoto, String urlBanner, String urlGitHub, String urlLinkedIn, Set<UserRol> userRols, List<Experiencie> experiencies, List<Education> educations, List<Project> projects, List<Skill> skills) {
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
        this.userRols = userRols;
        this.experiencies = experiencies;
        this.educations = educations;
        this.projects = projects;
        this.skills = skills;
    }

    public User(Long id, String username, String password, boolean enabled) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.enabled = enabled;
    }

    public User(Long id, String username, String password, boolean enabled, String name, String surname, String email, String titleProfession, String description, String urlPhoto, String urlBanner, String urlGitHub, String urlLinkedIn, Set<UserRol> userRols, List<Experiencie> experiencies, List<Education> educations, List<Project> projects, List<Skill> skills) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.titleProfession = titleProfession;
        this.description = description;
        this.urlPhoto = urlPhoto;
        this.urlBanner = urlBanner;
        this.urlGitHub = urlGitHub;
        this.urlLinkedIn = urlLinkedIn;
        this.userRols = userRols;
        this.experiencies = experiencies;
        this.educations = educations;
        this.projects = projects;
        this.skills = skills;
    }

    public User(String email) {
        this.email = email;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
        for (Skill variablelocal : skills) {
            variablelocal.setUser(this);
        }
    }

/*    public void setProjects(List<Project> projects) {
        this.projects = projects;
        for (Project variablelocal : projects) {
            variablelocal.setUser(this);
        }
    }*/

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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<Authority> autoridades = new HashSet<>();
        this.userRols.forEach(userRol -> {
            autoridades.add(new Authority(userRol.getRol().getNameRol()));
        });
        return autoridades;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTitleProfession() {
        return titleProfession;
    }

    public void setTitleProfession(String titleProfession) {
        this.titleProfession = titleProfession;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrlPhoto() {
        return urlPhoto;
    }

    public void setUrlPhoto(String urlPhoto) {
        this.urlPhoto = urlPhoto;
    }

    public String getUrlBanner() {
        return urlBanner;
    }

    public void setUrlBanner(String urlBanner) {
        this.urlBanner = urlBanner;
    }

    public String getUrlGitHub() {
        return urlGitHub;
    }

    public void setUrlGitHub(String urlGitHub) {
        this.urlGitHub = urlGitHub;
    }

    public String getUrlLinkedIn() {
        return urlLinkedIn;
    }

    public void setUrlLinkedIn(String urlLinkedIn) {
        this.urlLinkedIn = urlLinkedIn;
    }

    public Set<UserRol> getUserRols() {
        return userRols;
    }

    public void setUserRols(Set<UserRol> userRols) {
        this.userRols = userRols;
    }

    public List<Experiencie> getExperiencies() {
        return experiencies;
    }

    public List<Education> getEducations() {
        return educations;
    }

    public List<Project> getProjects() {
        return projects;
    }



    public List<Project> getProject(Optional<Project> update) {
        return projects;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void addProject(Project project) {
        projects.add(project);
        project.setUser(this);
    }

    public void addSkill(Skill skill) {
        skills.add(skill);
        skill.setUser(this);
    }

    public void addEducation(Education education) {
        educations.add(education);
        education.setUser(this);
    }

    public void addExperiencie(Experiencie experiencie) {
        experiencies.add(experiencie);
        experiencie.setUser(this);
    }


    public void removeProject(Project project) {
        projects.add(project);
        project.setUser(null);
    }

    public Long getId(Long idUser) {
        return idUser;
    }
}