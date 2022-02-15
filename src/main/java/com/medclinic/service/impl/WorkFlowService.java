package com.medclinic.service.impl;

import com.medclinic.dto.ClientWorkFlowDto;
import com.medclinic.dto.DoctorWorkFlowDto;
import com.medclinic.entity.*;
import com.medclinic.repository.IWorkFlowBodyRepository;
import com.medclinic.repository.IWorkFlowRepository;
import com.medclinic.service.IClientService;
import com.medclinic.service.IDoctorService;
import com.medclinic.service.IMedicalSvcService;
import com.medclinic.service.IWorkFlowService;
import com.medclinic.utils.DateParser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Slf4j
public class WorkFlowService implements IWorkFlowService {

    @Autowired
    private IWorkFlowRepository workFlowRepository;

    @Autowired
    private IDoctorService doctorService;

    @Autowired
    private IMedicalSvcService medicalSvcService;

    @Autowired
    private IClientService clientService;

    @Autowired
    private IWorkFlowBodyRepository workFlowBodyRepository;

    @Transactional
    @Override
    public void deleteWorkFlow(long id) {
        WorkFlow workFlow = (WorkFlow) workFlowRepository.findByID(id);
        workFlowRepository.delete(workFlow);
    }

    @Transactional
    @Override
    public void updateWorkFlow(long id, String login, DoctorWorkFlowDto dto) {
        WorkFlow workFlow = workFlowRepository.findByID(id);
        Doctor doctor = doctorService.findByLogin(login);
        MedicalService service = medicalSvcService.findById(dto.getServiceId());
        log.debug("Find data for update. Find service "+service.getName()+"(id:"+service.getId()+"). Find doctor " +
                " "+doctor.getFullName()+"("+doctor.getLogin()+") and find workflow id="+workFlow.getId()+". " +
                "Start date:"+workFlow.getStartDate().toString()+" - End date"+workFlow.getEndDate().toString());

        workFlow.setService(service);
        workFlow.setDoctor(doctor);
        workFlow.setEndDate(DateParser.getDateTimeByString(dto.getEndDateWorkFlow()));
        workFlow.setStartDate(DateParser.getDateTimeByString(dto.getStartDateWorkFlow()));

        workFlowRepository.save(workFlow);
        log.info("Update for doctor "+doctor.getFullName()+" workflow (id:"+workFlow.getId()+") new date between " +
                "("+workFlow.getStartDate()+" - "+workFlow.getEndDate()+").");
    }

    @Transactional
    @Override
    public WorkFlow createWorkFlow(String login, DoctorWorkFlowDto dto) {
        Doctor doctor = doctorService.findByLogin(login);
        MedicalService medicalService = medicalSvcService.findById(dto.getServiceId());

        WorkFlow workFlow = new WorkFlow();
        workFlow.setService(medicalService);
        workFlow.setWorked(false);
        workFlow.setDoctor(doctor);
        workFlow.setSizeClient(3);
        workFlow.setStartDate(DateParser.getDateTimeByString(dto.getStartDateWorkFlow()));
        workFlow.setEndDate(DateParser.getDateTimeByString(dto.getEndDateWorkFlow()));

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

    @Override
    public Set<WorkFlowBody> findWorkFlowBodiesById(long wfID) {
        WorkFlow workFlow = workFlowRepository.findByID(wfID);
        return workFlow.getBodySet();
    }

    @Override
    @Transactional
    public LocalDateTime createWorkFlowBody(ClientWorkFlowDto dto, long wfId){
        Client client = clientService.findById(dto.getClientID());
        Doctor doctor = doctorService.findById(dto.getDoctorID());
        MedicalService medicalService = medicalSvcService.findById(dto.getServiceID());
        WorkFlow workFlow = workFlowRepository.findByID(wfId);

        WorkFlowBody workFlowBody = new WorkFlowBody();
        workFlowBody.setService(medicalService);
        workFlowBody.setCreateDate(LocalDateTime.now());
        workFlowBody.setDoctor(doctor);
        workFlowBody.setClient(client);
        workFlowBody.setDescribeComplain(dto.getComplaint());
        workFlowBody.setReceiptOfDate(DateParser.getDateTimeByString(dto.getRecipeDate()));
        workFlowBody.setWorkFlow(workFlow);

        if (workFlow.getBodySet().isEmpty()) {
            Set<WorkFlowBody> set = new HashSet<>();
            set.add(workFlowBody);
            workFlow.setBodySet(set);
        } else {
            Set<WorkFlowBody> set = workFlow.getBodySet();
            set.add(workFlowBody);
            workFlow.setBodySet(null);
            workFlow.setBodySet(set);
        }

        workFlowBodyRepository.save(workFlowBody);
        workFlowRepository.save(workFlow);

        return workFlowBody.getReceiptOfDate();
    }

    @Override
    @Transactional
    public void toRecipeClient(long wfBodyId) {
        WorkFlowBody flowBody = workFlowBodyRepository.findByID(wfBodyId);

        flowBody.setReceipt(true);

        workFlowBodyRepository.save(flowBody);
    }
}
