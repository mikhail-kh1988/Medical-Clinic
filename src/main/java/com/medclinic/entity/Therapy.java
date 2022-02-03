package com.medclinic.entity;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "therapy")
public class Therapy implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "describe_complaint")
    private String describeComplaint;

    @ManyToOne(cascade = CascadeType.ALL)
    private Disease disease;

    @Column(name = "therapy")
    private String therapy;

}
