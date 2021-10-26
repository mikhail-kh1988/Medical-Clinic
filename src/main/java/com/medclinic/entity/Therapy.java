package com.medclinic.entity;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescribeComplaint() {
        return describeComplaint;
    }

    public void setDescribeComplaint(String describeComplaint) {
        this.describeComplaint = describeComplaint;
    }

    public Disease getDisease() {
        return disease;
    }

    public void setDisease(Disease disease) {
        this.disease = disease;
    }

    public String getTherapy() {
        return therapy;
    }

    public void setTherapy(String therapy) {
        this.therapy = therapy;
    }
}
