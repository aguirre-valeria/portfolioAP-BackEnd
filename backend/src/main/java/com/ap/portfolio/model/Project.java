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
@Table(name = "project")
public class Project implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProj;
    @NotNull
    @Size(min = 1, max = 45, message = "No cumple con la longitud")
    private String titleProj;
    @Size(min = 1, max = 255, message = "No cumple con la longitud")
    private String descriptionProj;
    @NotNull
    @Size(min = 1, max = 255, message = "No cumple con la longitud")
    private String urlPhoto;
    @Size(min = 1, max = 255, message = "No cumple con la longitud")
    private String urlGitHubProj;
    @Size(min = 1, max = 255, message = "No cumple con la longitud")
    private String urlDemo;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name="user_id", nullable=false, updatable = false)
    @JsonProperty(access = Access.WRITE_ONLY)
    private User user;

    public Project() {
    }

    public Project(Long idProj, String titleProj, String descriptionProj, String urlPhoto, String urlGitHubProj, String urlDemo) {
        this.idProj = idProj;
        this.titleProj = titleProj;
        this.descriptionProj = descriptionProj;
        this.urlPhoto = urlPhoto;
        this.urlGitHubProj = urlGitHubProj;
        this.urlDemo = urlDemo;
    }

    public Project(Long idProj, String titleProj, String descriptionProj, String urlPhoto, String urlGitHubProj, String urlDemo, User user) {
        this.idProj = idProj;
        this.titleProj = titleProj;
        this.descriptionProj = descriptionProj;
        this.urlPhoto = urlPhoto;
        this.urlGitHubProj = urlGitHubProj;
        this.urlDemo = urlDemo;
        this.user = user;
    }

    public Project(Long idProj, String titleProj, String descriptionProj, String urlPhoto, String urlGitHubProj, String urlDemo, Long id) {
    }

    public Long getIdProj() {
        return idProj;
    }

    public Project updateWith(Long idUser, Project project) {
        return new Project(
                project.idProj,
                project.titleProj,
                project.descriptionProj,
                project.urlPhoto,
                project.urlGitHubProj,
                project.urlDemo,
                project.user.getId(idUser)
        );
    }
}
