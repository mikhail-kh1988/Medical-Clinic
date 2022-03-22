package com.medclinic.repository;

import com.medclinic.config.hibernate.GenericDAO;
import com.medclinic.entity.WorkFlow;

import java.time.LocalDateTime;
import java.util.List;

public interface IWorkFlowRepository extends GenericDAO<WorkFlow> {
    List<WorkFlow> findByDoctorId(long id);
    List<WorkFlow> findByServiceId(long id);
    WorkFlow findWorkFlowByCurrentDate(LocalDateTime currentDate, long doctor_Id);
}
