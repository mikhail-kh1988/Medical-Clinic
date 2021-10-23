package com.medclinic.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE_USER")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "login", length = 32)
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

    public StatusUser getStatus() {
        return status;
    }

    public void setStatus(StatusUser status) {
        this.status = status;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public char getFirstSymbolName() {
        return firstSymbolName;
    }

    public void setFirstSymbolName(char firstSymbolName) {
        this.firstSymbolName = firstSymbolName;
    }
}
