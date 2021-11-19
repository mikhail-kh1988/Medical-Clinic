package com.medclinic.service.impl;

import com.medclinic.dto.DoctorWorkFlowDto;
import com.medclinic.entity.Doctor;
import com.medclinic.entity.MedicalService;
import com.medclinic.entity.WorkFlow;
import com.medclinic.repository.IWorkFlowRepository;
import com.medclinic.service.IDoctorService;
import com.medclinic.service.IMedicalSvcService;
import com.medclinic.service.IWorkFlowService;
import com.medclinic.tools.DateParser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Slf4j
public class WorkFlowService implements IWorkFlowService {

    @Autowired
    private IWorkFlowRepository workFlowRepository;

    @Autowired
    private IDoctorService doctorService;

    @Autowired
    private IMedicalSvcService medicalSvcService;

    @Override
    public void deleteWorkFlow(long id) {

    }

    @Override
    public void updateWorkFlow(long id, DoctorWorkFlowDto dto) {

    }

    @Transactional
    @Override
    public WorkFlow createWorkFlow(DoctorWorkFlowDto dto) {
        Doctor doctor = doctorService.findByLogin(dto.getLoginDoctor());
        MedicalService medicalService = medicalSvcService.findById(dto.getServiceId());

        WorkFlow workFlow = new WorkFlow();
        workFlow.setService(medicalService);
        workFlow.setWorked(false);
        workFlow.setDoctor(doctor);
        workFlow.setSizeClient(10);
        workFlow.setStartDate(DateParser.getDateByString(dto.getStartDateWorkFlow()));
        workFlow.setEndDate(DateParser.getDateByString(dto.getEndDateWorkFlow()));

        workFlowRepository.save(workFlow);
        log.info("Create new workflow "+doctor.getFullName()+" for date "+dto.getStartDateWorkFlow()+" and "+dto.getEndDateWorkFlow());
        return workFlow;
    }

    @Override
    public List<WorkFlow> findByDoctorId(long id) {
        return workFlowRepository.findByDoctorId(id);
    }

    @Override
    public List<WorkFlow> findByServiceId(long id) {
        return workFlowRepository.findByServiceId(id);
    }
}
