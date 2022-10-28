package com.ap.portfolio.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;

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
    private LocalDate startDateExp;
    @NotNull
    private LocalDate endDateExp;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false, updatable = false)
    private User user;

    public Experiencie() {

    }

    public Experiencie(Long idExp, String titleExp, String descriptionExp, LocalDate startDateExp, LocalDate endDateExp) {
        this.idExp = idExp;
        this.titleExp = titleExp;
        this.descriptionExp = descriptionExp;
        this.startDateExp = startDateExp;
        this.endDateExp = endDateExp;
    }
}
