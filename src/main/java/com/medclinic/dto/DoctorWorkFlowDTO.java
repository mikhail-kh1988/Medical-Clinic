package com.medclinic.dto;

public class DoctorWorkFlowDTO {

    private String loginDoctor;
    private String startDateWorkFlow;
    private String endDateWorkFlow;
    private long serviceId;

    public DoctorWorkFlowDTO(String loginDoctor, String startDateWorkFlow, String endDateWorkFlow, long serviceId) {
        this.loginDoctor = loginDoctor;
        this.startDateWorkFlow = startDateWorkFlow;
        this.endDateWorkFlow = endDateWorkFlow;
        this.serviceId = serviceId;
    }

    public DoctorWorkFlowDTO() {
    }

    public String getLoginDoctor() {
        return loginDoctor;
    }

    public void setLoginDoctor(String loginDoctor) {
        this.loginDoctor = loginDoctor;
    }

    public String getStartDateWorkFlow() {
        return startDateWorkFlow;
    }

    public void setStartDateWorkFlow(String startDateWorkFlow) {
        this.startDateWorkFlow = startDateWorkFlow;
    }

    public String getEndDateWorkFlow() {
        return endDateWorkFlow;
    }

    public void setEndDateWorkFlow(String endDateWorkFlow) {
        this.endDateWorkFlow = endDateWorkFlow;
    }

    public long getServiceId() {
        return serviceId;
    }

    public void setServiceId(long serviceId) {
        this.serviceId = serviceId;
    }
}
