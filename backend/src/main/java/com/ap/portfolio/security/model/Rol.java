package com.ap.portfolio.security.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "rol")
public class Rol {

    @Id
    private Long idRol;

    private String nameRol;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "rol")
    private Set<UserRol> userRols = new HashSet<>();

    public Rol() {
    }

    public Rol(Long idRol, String nameRol) {
        this.idRol = idRol;
        this.nameRol = nameRol;
    }

    public Long getIdRol() {
        return idRol;
    }

    public void setIdRol(Long idRol) {
        this.idRol = idRol;
    }

    public String getNameRol() {
        return nameRol;
    }

    public void setNameRol(String nameRol) {
        this.nameRol = nameRol;
    }

    public Set<UserRol> getUserRols() {
        return userRols;
    }

    public void setUserRols(Set<UserRol> userRols) {
        this.userRols = userRols;
    }
}
