package com.medclinic.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "department")
public class Department implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "dep_name", unique = true)
    private String departmentName;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "id")
    private List<Doctor> doctorList;

    public void addDoctor(Doctor doctor){
        if (doctorList.isEmpty()){
            doctorList = new ArrayList<>();
        }
        doctorList.add(doctor);
    }
}
