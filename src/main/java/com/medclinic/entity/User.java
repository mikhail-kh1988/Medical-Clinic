package com.medclinic.entity;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;

@Data
@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE_USER")
public class User implements Serializable, UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "login", length = 32, unique = true)
    private String login;

    @Column(name = "password", length = 128)
    private String password;

    @Column(name = "email", length = 64)
    private String email;

    private Integer age;
    private boolean online;

    @Column(name = "status_user", length = 16)
    @Enumerated(EnumType.STRING)
    private StatusUser status;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "family_name")
    private String familyName;

    @Column(name = "first_symbol_name")
    private char firstSymbolName;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "USERS_ROLES", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> role;

    @Transient
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return role;
    }

    @Transient
    @Override
    public String getUsername() {
        return login;
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

    @Override
    public boolean isEnabled() {
        return true;
    }
}
