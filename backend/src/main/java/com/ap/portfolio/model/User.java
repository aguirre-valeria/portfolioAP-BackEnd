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
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 1, max = 50, message = "No cumple con la longitud")
    private String name;

    @NotNull
    @Size(min = 1, max = 50, message = "No cumple con la longitud")
    private String surname;

    @NotNull
    @Size(min = 1, max = 80, message = "No cumple con la longitud")
    private String titleProfession;

    private String description;
    private String urlPhoto;
    private String urlBanner;
    private String urlGitHub;
    private String urlLinkedIn;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "idExp")
    private List<Experiencie> experiencieList;

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
}