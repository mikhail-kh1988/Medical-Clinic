package com.medclinic.service;

import com.medclinic.dto.DoctorWorkFlowDTO;
import com.medclinic.entity.WorkFlow;

import java.util.List;

public interface IWorkFlowService {
    void deleteWorkFlow(long id);
    void updateWorkFlow(long id, DoctorWorkFlowDTO dto);
    WorkFlow createWorkFlow(DoctorWorkFlowDTO dto);
    List<WorkFlow> findByDoctorId(long id);
    List<WorkFlow> findByServiceId(long id);
}
