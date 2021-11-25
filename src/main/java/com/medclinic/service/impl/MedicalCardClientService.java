package com.medclinic.service.impl;

import com.medclinic.dto.MedicalCardBodyDto;
import com.medclinic.entity.*;
import com.medclinic.repository.IMedicalCardClientRepository;
import com.medclinic.service.*;
import com.medclinic.utils.DateParser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@Service
public class MedicalCardClientService implements IMedicalCardClientService {

    @Autowired
    private IMedicalCardClientRepository medicalCardClientRepository;

    @Autowired
    private IDoctorService doctorService;

    @Autowired
    private IClientService clientService;

    @Autowired
    private IDiseaseService diseaseService;

    @Autowired
    private IDepartmentService departmentService;

    @Override
    public MedicalCardClient createNewMedicalCard(MedicalCardClient cardClient) {
        return null;
    }

    @Override
    public MedicalCardClient findById(long id) {
        return (MedicalCardClient) medicalCardClientRepository.findByID(id);
    }

    @Override
    public List<MedicalCardClient> findByDoctorId(long id) {
        return medicalCardClientRepository.findByDoctorId(id);
    }

    @Override
    public List<MedicalCardClient> findByChronicDisease(String diseases) {
        return medicalCardClientRepository.findByChronicDisease(diseases);
    }

    @Override
    public MedicalCardClient findByClientId(long id) {
        return (MedicalCardClient) medicalCardClientRepository.findByClientId(id);
    }

    @Transactional
    @Override
    public void newRecordInCard(long medCardID, MedicalCardBodyDto dto) {
        MedicalCardClient medicalCardClient = (MedicalCardClient) medicalCardClientRepository.findByID(medCardID);
        log.debug("Find medical card client "+medicalCardClient.getClient().getFullName()+". ");

        Doctor doctor = doctorService.findById(dto.getDoctorID());
        log.debug("Find doctor "+doctor.getFullName()+" by login "+doctor.getLogin());

        Client client = clientService.findById(dto.getClientID());
        log.debug("Find client "+client.getFullName()+" by login "+client.getLogin());

        Disease disease = diseaseService.findByID(dto.getDiseaseID());
        log.debug("Find disease by id "+disease.getId());

        Department department = departmentService.findDepartmentByID(dto.getDepartmentID());
        log.debug("Find department "+department.getDepartmentName()+" by id"+department.getId());

        Therapy therapy = new Therapy();
        therapy.setTherapy(dto.getTherapy());
        therapy.setDescribeComplaint(dto.getComplaint());
        log.debug("Create new therapy "+therapy.getTherapy());

        Comment comment = new Comment();
        comment.setDescription(dto.getComment());
        comment.setCreateUser(doctor);
        comment.setCreateDate(LocalDate.now());
        log.debug("Create new comment by login <"+comment.getCreateUser().getLogin()+">");

        MedicalCardBody medicalCardBody = new MedicalCardBody();
        medicalCardBody.setMedicalCard(medicalCardClient);
        medicalCardBody.setTherapyClosed(dto.isTherapyClosed());
        medicalCardBody.setDisease(disease);
        medicalCardBody.setDoctor(doctor);
        medicalCardBody.setClient(client);
        medicalCardBody.setTherapy(therapy);
        medicalCardBody.setFutureDateRecipient(DateParser.getDateByString(dto.getFutureDateRecipient()));
        medicalCardBody.setComment(comment);
        medicalCardBody.setDepartment(department);
        medicalCardBody.setCreateDate(LocalDate.now());

        medicalCardClientRepository.save(medicalCardBody);
        log.info("Added into med card "+medCardID+" new record medical card body.");

    }
}
