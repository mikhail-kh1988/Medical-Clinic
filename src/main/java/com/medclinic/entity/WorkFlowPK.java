package com.medclinic.entity;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class WorkFlowPK implements Serializable {

    @ManyToOne
    private WorkFlow workFlow;

    @ManyToOne
    private Doctor doctor;


}
