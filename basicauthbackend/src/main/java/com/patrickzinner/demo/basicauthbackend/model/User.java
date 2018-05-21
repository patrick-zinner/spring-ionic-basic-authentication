package com.patrickzinner.demo.basicauthbackend.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.Collection;
import java.util.Collections;

/**
 * The model for our User. We want to store our users in the database, therefore we have to create our own entity that implements {@link UserDetails}.
 */
@Entity
@Table(name = "registered_user") //using registered_user as a table name because user is a Postgres keyword
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Email
    @Column(unique = true, nullable = false)
    private String emailAddress;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Override
    public Collection<Roles> getAuthorities() {
        return Collections.singletonList(Roles.USER);
    }

    @Override
    public String getPassword() {
        return username;
    }

    @Override
    public String getUsername() {
        return username;
    }

    //you can implement some logic here or use data from the DB if you like. for the sake of simplicity we just asume that no user is expired, locked or whatever
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
        return true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
