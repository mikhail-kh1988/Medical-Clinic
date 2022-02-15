package com.medclinic.service.impl;

import com.medclinic.dto.*;
import com.medclinic.entity.*;
import com.medclinic.exception.NotUniqueUserRegistrationException;
import com.medclinic.repository.IDoctorRepository;
import com.medclinic.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Slf4j
public class DoctorService implements IDoctorService {

    @Autowired
    private IDoctorRepository doctorRepository;

    @Autowired
    private IWorkFlowService workFlowService;

    @Autowired
    private IMedicalSvcService medicalSvcService;

    @Autowired
    private IMedicalCardClientService medicalCardClientService;

    @Autowired
    private IClientService clientService;

    @Autowired
    private IDepartmentService departmentService;

    @Autowired
    private IDiseaseService diseaseService;

    @Transactional
    @Override
    public Doctor createNewDoctor(DoctorDto dto) throws NotUniqueUserRegistrationException {
        Doctor doctor =  new Doctor();
        doctor.setLogin(dto.getLogin());
        doctor.setPassword(dto.getPassword());
        doctor.setEmail(dto.getEmail());
        doctor.setSpecializationName(dto.getSpecializationName());
        doctor.setCertificateNumber(dto.getCertificateNumber());
        doctor.setWhereStudy(dto.getWhereStudy());
        doctor.setFullName(dto.getFullName());
        doctor.setAge(dto.getAge());
        doctor.setFamilyName(dto.getFamilyName());
        doctor.setFirstSymbolName(dto.getFamilyName().charAt(0));

        Set<Role> roles = new HashSet<>();
        roles.add(Role.DOCTOR);

        doctor.setRole(roles);

        doctorRepository.save(doctor);

        log.info("Create doctor "+doctor.getFullName()+" by login: "+doctor.getLogin());
        return doctor;
    }

    @Transactional
    @Override
    public long setWorkFlow(String login, DoctorWorkFlowDto dto) {
        WorkFlow flow = workFlowService.createWorkFlow(login, dto);
        log.info("Doctor "+login+" set workflow between "+dto.getStartDateWorkFlow()+" and "+dto.getEndDateWorkFlow());
        return flow.getId();
    }

    @Transactional
    @Override
    public void deleteDoctor(long id) {
        Doctor doctor = (Doctor) doctorRepository.findByID(id);
        doctorRepository.delete(doctor);
        log.info("Delete doctor by "+doctor.getFullName());
    }

    @Transactional
    @Override
    public void updateDoctor(long id, DoctorDto dto) {
        Doctor doctor = (Doctor) doctorRepository.findByID(id);
        doctor.setEmail(dto.getEmail());
        doctor.setSpecializationName(dto.getSpecializationName());
        doctor.setCertificateNumber(dto.getCertificateNumber());
        doctor.setWhereStudy(dto.getWhereStudy());
        doctor.setFullName(dto.getFullName());
        doctor.setFamilyName(dto.getFamilyName());

        doctorRepository.save(doctor);
        log.info("Update doctor by login "+doctor.getLogin());
    }

    @Transactional
    @Override
    public void addNewService(long serviceID, long doctorID) {
        MedicalService medicalService = medicalSvcService.findById(serviceID);
        Doctor doctor = (Doctor) doctorRepository.findByID(doctorID);

        doctor.getMyServices().add(medicalService);
        log.info("Doctor by "+doctor.getFullName()+" was added service by "+medicalService.getName()+".");
        doctorRepository.save(doctor);
    }

    @Override
    public List<Doctor> findByFullName(String fullName) {
        return doctorRepository.findByFullName(fullName);
    }

    @Override
    public Doctor findByLogin(String login) {
        return (Doctor) doctorRepository.findByLogin(login);
    }

    @Override
    public Doctor findById(long id) {
        return (Doctor) doctorRepository.findByID(id);
    }

    @Override
    public List<Doctor> findByFamily(String family) {
        return doctorRepository.findByFamily(family);
    }

    @Override
    public Doctor findByEmail(String email) {
        return (Doctor) doctorRepository.findByEmail(email);
    }

    @Override
    public List<Doctor> findAll() {
        return doctorRepository.findAll();
    }

    @Override
    public List<Doctor> findByOnline() {
        return doctorRepository.findByOnline();
    }

    @Override
    public List<Doctor> findBySpecializationName(String specName) {
        return doctorRepository.findBySpecializationName(specName);
    }

    @Override
    public List<Doctor> findByWhereStudy(String whereStudy) {
        return doctorRepository.findByWhereStudy(whereStudy);
    }

    //TODO Доделать логику поиска всех клиентов доктора.
    @Override
    public List<Client> getListMyClients(long doctorID) {
        return null;
    }

    @Override
    public List<WorkFlow> getListMyWorkFlow(long doctorID) {
        return workFlowService.findByDoctorId(doctorID);
    }

    //TODO Реализовать выдачу рабочего графика врача.
    @Override
    public WorkFlow getMyWorkFlow(LocalDate currentDate, long doctorID) {
        List<WorkFlow> list =  workFlowService.findByDoctorId(doctorID);
        return null;
    }

    @Override
    public MedicalCardClient getMedicalCard(long clientID) {
        return medicalCardClientService.findByClientId(clientID);
    }

    @Transactional
    @Override
    public MedicalCardClient createMedicalCard(MedicalCardDto dto, long doctorID) {
        Client client = clientService.findById(dto.getClientID());
        Doctor doctor = doctorRepository.findByID(doctorID);

        MedicalCardClient cardClient = new MedicalCardClient();
        cardClient.setClient(client);
        cardClient.setCreateDate(LocalDate.now());
        cardClient.setBloodGroup(dto.getBloodGroup());
        cardClient.setChronicDisease(dto.getChronicDisease());
        cardClient.setDescribe(dto.getDescribe());
        cardClient.setTherapyDoctor(doctor);

        log.info("Doctor "+doctor.getFullName()+" create mew medical card for client "+client.getFullName());

        medicalCardClientService.createNewMedicalCard(cardClient);
        return cardClient;
    }

    @Transactional
    @Override
    public void addNewRecordInMedicalCardClient(MedicalCardBodyDto dto, long medCardID) {

        MedicalCardClient medicalCard = medicalCardClientService.findById(medCardID);
        Doctor doctor = doctorRepository.findByID(dto.getDoctorID());
        Client client = clientService.findById(dto.getClientID());
        Department department = departmentService.findDepartmentByID(dto.getDepartmentID());
        log.debug("Find components: doctor = "+doctor.getId()+" client = "+client.getId()+" department = "+department.getId());
        medicalCardClientService.newRecordInCard(medCardID, dto);
    }
}
