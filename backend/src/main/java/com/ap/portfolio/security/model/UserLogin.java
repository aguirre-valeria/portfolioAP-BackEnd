package com.ap.portfolio.security.model;

import com.ap.portfolio.model.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "user_login")
public class UserLogin implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;

    private String username;
    private String password;
    private String email;
    private boolean enabled = true;

    @OneToMany(mappedBy = "userLogin", cascade = CascadeType.ALL)
    private List<User> users;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "userLogin")
    @JsonIgnore
    private Set<UserRol> userRols = new HashSet<>();

    public UserLogin() {
    }

    public UserLogin(Long idUser, String username, String password, String email, boolean enabled) {
        this.idUser = idUser;
        this.username = username;
        this.password = password;
        this.email = email;
        this.enabled = enabled;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

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

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<Authority> autoridades = new HashSet<>();
        this.userRols.forEach(userRol -> {
            autoridades.add(new Authority(userRol.getRol().getNameRol()));
        });
        return autoridades;
    }

    public String getPassword() {
        return password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Set<UserRol> getUserRols() {
        return userRols;
    }

    public void setUserRols(Set<UserRol> userRols) {
        this.userRols = userRols;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
