package com.ap.portfolio.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "education")
public class Education implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY
    )
    private Long idEdu;
    @NotNull
    @Size(min = 1, max = 45, message = "No cumple con la longitud")
    private String titleEdu;
    @Size(min = 1, max = 255, message = "No cumple con la longitud")
    private String descriptionEdu;
    @NotNull
    private LocalDate startDateEdu;
    @NotNull
    private LocalDate endDateEdu;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="user_id", nullable=false, updatable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private User user;

    public Education() {
    }

    public Education(Long idEdu, String titleEdu, String descriptionEdu, LocalDate startDateEdu, LocalDate endDateEdu) {
        this.idEdu = idEdu;
        this.titleEdu = titleEdu;
        this.descriptionEdu = descriptionEdu;
        this.startDateEdu = startDateEdu;
        this.endDateEdu = endDateEdu;
    }
}