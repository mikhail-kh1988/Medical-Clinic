package com.medclinic.service;

import com.medclinic.dto.DoctorDTO;
import com.medclinic.dto.DoctorWorkFlowDTO;
import com.medclinic.dto.MedicalCardBodyDTO;
import com.medclinic.dto.MedicalCardDTO;
import com.medclinic.entity.Client;
import com.medclinic.entity.Doctor;
import com.medclinic.entity.MedicalCardClient;
import com.medclinic.entity.WorkFlow;

import java.util.GregorianCalendar;
import java.util.List;

public interface IDoctorService {

    Doctor createNewDoctor(DoctorDTO dto);
    void setWorkFlow(DoctorWorkFlowDTO dto);
    void deleteDoctor(long id);
    void updateDoctor(long id, DoctorDTO dto);
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
    MedicalCardClient createMedicalCard(MedicalCardDTO dto);
    void addNewRecordInMedicalCardClient(MedicalCardBodyDTO dto, long medCardID);
}
