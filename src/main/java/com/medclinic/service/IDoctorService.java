package com.medclinic.service;

import com.medclinic.dto.*;
import com.medclinic.entity.Client;
import com.medclinic.entity.Doctor;
import com.medclinic.entity.MedicalCardClient;
import com.medclinic.entity.WorkFlow;
import com.medclinic.exception.NotUniqueUserRegistrationException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface IDoctorService {

    Doctor createNewDoctor(DoctorDto dto) throws NotUniqueUserRegistrationException;
    long setWorkFlow(String login, DoctorWorkFlowDto dto);
    void deleteDoctor(long id);
    void updateDoctor(long id, DoctorDto dto);
    void addNewService(long serviceID, long doctorID);
    List<Doctor> findByFullName(String fullName);
    Doctor findByLogin(String login);
    Doctor findById(long id);
    List<Doctor> findByFamily(String family);
    Doctor findByEmail(String email);
    List<Doctor> findAll();
    List<Doctor> findByOnline();
    List<Doctor> findBySpecializationName(String specName);
    List<Doctor> findByWhereStudy(String whereStudy);
    List<Client> getListMyClients(long doctorID);
    WorkFlow getMyWorkFlow(LocalDateTime currentDate, long doctorID);
    List<WorkFlow> getListMyWorkFlow(long doctorID);
    MedicalCardClient getMedicalCard(long clientID);
    MedicalCardClient createMedicalCard(MedicalCardDto dto, long doctorID);
    void addNewRecordInMedicalCardClient(MedicalCardBodyDto dto, long medCardID);
}
