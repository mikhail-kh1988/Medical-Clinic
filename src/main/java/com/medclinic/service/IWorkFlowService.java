package com.medclinic.service;

import com.medclinic.dto.ClientWorkFlowDto;
import com.medclinic.dto.DoctorWorkFlowDto;
import com.medclinic.entity.WorkFlow;
import com.medclinic.entity.WorkFlowBody;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public interface IWorkFlowService {
    void deleteWorkFlow(long id);
    void updateWorkFlow(long id, String login, DoctorWorkFlowDto dto);
    WorkFlow createWorkFlow(String login, DoctorWorkFlowDto dto);
    List<WorkFlow> findByDoctorId(long id);
    List<WorkFlow> findByServiceId(long id);
    Set<WorkFlowBody> findWorkFlowBodiesById(long wfID);
    LocalDateTime createWorkFlowBody(ClientWorkFlowDto dto, long wfId);
    void toRecipeClient(long wfBodyId);
}
