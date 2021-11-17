package com.medclinic.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.GregorianCalendar;

@Entity
@Table(name = "WORKFLOW_BODY")
@AssociationOverrides(
        {@AssociationOverride(name = "primaryKey.client", joinColumns = @JoinColumn(name = "client_id")),
        @AssociationOverride(name = "primaryKey.doctor", joinColumns = @JoinColumn(name = "doctor_id"))}
)
public class WorkFlowBody {

    @EmbeddedId
    private WorkFlowPK primaryKey = new WorkFlowPK();

    @ManyToOne(cascade = CascadeType.ALL)
    private WorkFlow workFlow;

    @Column(name = "create_date")
    private LocalDate createDate;

    @Column(name = "receipt_date")
    private LocalDate receiptOfDate;

    @Column(name = "describe_complaint")
    private String describeComplain;

    @ManyToOne(cascade = CascadeType.ALL)
    private MedicalService service;

    @Column(name = "receipt")
    private boolean receipt;

    @Transient
    public Doctor getDoctor(){
        return primaryKey.getDoctor();
    }

    public void setDoctor(Doctor doctor){
        primaryKey.setDoctor(doctor);
    }

    @Transient
    public Client getClient(){
        return primaryKey.getClient();
    }

    public void setClient(Client client){
        primaryKey.setClient(client);
    }

    public WorkFlowPK getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(WorkFlowPK primaryKey) {
        this.primaryKey = primaryKey;
    }

    public WorkFlow getWorkFlow() {
        return workFlow;
    }

    public void setWorkFlow(WorkFlow workFlow) {
        this.workFlow = workFlow;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public LocalDate getReceiptOfDate() {
        return receiptOfDate;
    }

    public void setReceiptOfDate(LocalDate receiptOfDate) {
        this.receiptOfDate = receiptOfDate;
    }

    public String getDescribeComplain() {
        return describeComplain;
    }

    public void setDescribeComplain(String describeComplain) {
        this.describeComplain = describeComplain;
    }

    public MedicalService getService() {
        return service;
    }

    public void setService(MedicalService service) {
        this.service = service;
    }

    public boolean isReceipt() {
        return receipt;
    }

    public void setReceipt(boolean receipt) {
        this.receipt = receipt;
    }
}
