package com.ap.portfolio.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

@Getter @Setter
@Entity
public class Experiencie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idExp;
    private String titleExp;
    private String descriptionExp;
    private Date startDateExp;
    private Date endDateExp;

    public Experiencie() {

    }

    public Experiencie(Long idExp, String titleExp, String descriptionExp, Date startDateExp, Date endDateExp) {
        this.idExp = idExp;
        this.titleExp = titleExp;
        this.descriptionExp = descriptionExp;
        this.startDateExp = startDateExp;
        this.endDateExp = endDateExp;
    }
}
