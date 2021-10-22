package com.medclinic.entity;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "diseases")
public class Disease implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "internal_code")
    private String internalCode;

    @Column(name = "external_code")
    private String externalCode;

    @Column(name = "world_code")
    private String worldCode;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInternalCode() {
        return internalCode;
    }

    public void setInternalCode(String internalCode) {
        this.internalCode = internalCode;
    }

    public String getExternalCode() {
        return externalCode;
    }

    public void setExternalCode(String externalCode) {
        this.externalCode = externalCode;
    }

    public String getWorldCode() {
        return worldCode;
    }

    public void setWorldCode(String worldCode) {
        this.worldCode = worldCode;
    }
}
