package com.medclinic.service;

import com.medclinic.dto.DoctorDto;
import com.medclinic.dto.DoctorWorkFlowDto;
import com.medclinic.dto.MedicalCardBodyDto;
import com.medclinic.dto.MedicalCardDto;
import com.medclinic.entity.Client;
import com.medclinic.entity.Doctor;
import com.medclinic.entity.MedicalCardClient;
import com.medclinic.entity.WorkFlow;

import java.util.GregorianCalendar;
import java.util.List;

public interface IDoctorService {

    Doctor createNewDoctor(DoctorDto dto);
    void setWorkFlow(DoctorWorkFlowDto dto);
    void deleteDoctor(long id);
    void updateDoctor(long id, DoctorDto dto);
    void addNewService(long serviceID);
    List<Doctor> findByFullName(String fullName);
    Doctor findByLogin(String login);
    List<Doctor> findByFamily(String family);
    Doctor findByEmail(String email);
    List<Doctor> findByOnline();
    List<Doctor> findBySpecializationName(String specName);
    List<Doctor> findByWhereStudy(String whereStudy);
    List<Client> getListMyClients(long doctorID);
    WorkFlow getMyWorkFlow(GregorianCalendar currentDate, long doctorID);
    MedicalCardClient getMedicalCard(long clientID);
    MedicalCardClient createMedicalCard(MedicalCardDto dto);
    void addNewRecordInMedicalCardClient(MedicalCardBodyDto dto, long medCardID);
}
