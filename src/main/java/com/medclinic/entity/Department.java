package com.medclinic.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "department")
public class Department implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "dep_name", unique = true)
    private String departmentName;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Doctor> doctorList;

    public void addDoctor(Doctor doctor){
        if (doctorList.isEmpty()){
            doctorList = new ArrayList<>();
        }
        doctorList.add(doctor);
    }
}
