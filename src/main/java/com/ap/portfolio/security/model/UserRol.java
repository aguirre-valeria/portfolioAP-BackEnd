package com.ap.portfolio.security.model;

import com.ap.portfolio.model.User;

import javax.persistence.*;

@Entity
public class UserRol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUserRol;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id_user")
    private User user;

    @ManyToOne
    private Rol rol;

    public Long getIdUserRol() {
        return idUserRol;
    }

    public void setIdUserRol(Long idUserRol) {
        this.idUserRol = idUserRol;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
}
