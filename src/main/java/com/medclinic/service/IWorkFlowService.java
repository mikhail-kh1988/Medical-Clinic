package com.medclinic.service;

import com.medclinic.dto.DoctorWorkFlowDto;
import com.medclinic.entity.WorkFlow;

import java.util.List;

public interface IWorkFlowService {
    void deleteWorkFlow(long id);
    void updateWorkFlow(long id, DoctorWorkFlowDto dto);
    WorkFlow createWorkFlow(DoctorWorkFlowDto dto);
    List<WorkFlow> findByDoctorId(long id);
    List<WorkFlow> findByServiceId(long id);
}
