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
@Table(name = "experiencie")
public class Experiencie implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idExp;
    @NotNull
    @Size(min = 1, max = 45, message = "No cumple con la longitud")
    private String titleExp;
    @Size(min = 1, max = 255, message = "No cumple con la longitud")
    private String descriptionExp;
    @NotNull
    private int startDateExp;
    @NotNull
    private int endDateExp;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name="user_id", nullable=false, updatable = false)
    @JsonProperty(access = Access.WRITE_ONLY)
    private User user;

    public Experiencie() {

    }

    public Experiencie(Long idExp, String titleExp, String descriptionExp, int startDateExp, int endDateExp) {
        this.idExp = idExp;
        this.titleExp = titleExp;
        this.descriptionExp = descriptionExp;
        this.startDateExp = startDateExp;
        this.endDateExp = endDateExp;
    }
}
