package com.medclinic.service.impl;

import com.medclinic.dto.DoctorDto;
import com.medclinic.dto.DoctorWorkFlowDto;
import com.medclinic.dto.MedicalCardBodyDto;
import com.medclinic.dto.MedicalCardDto;
import com.medclinic.entity.Client;
import com.medclinic.entity.Doctor;
import com.medclinic.entity.MedicalCardClient;
import com.medclinic.entity.WorkFlow;
import com.medclinic.service.IDoctorService;

import java.util.GregorianCalendar;
import java.util.List;

public class DoctorService implements IDoctorService {

    @Override
    public Doctor createNewDoctor(DoctorDto dto) {
        return null;
    }

    @Override
    public void setWorkFlow(DoctorWorkFlowDto dto) {

    }

    @Override
    public void deleteDoctor(long id) {

    }

    @Override
    public void updateDoctor(long id, DoctorDto dto) {

    }

    @Override
    public void addNewService(long serviceID) {

    }

    @Override
    public List<Doctor> findByFullName(String fullName) {
        return null;
    }

    @Override
    public Doctor findByLogin(String login) {
        return null;
    }

    @Override
    public List<Doctor> findByFamily(String family) {
        return null;
    }

    @Override
    public Doctor findByEmail(String email) {
        return null;
    }

    @Override
    public List<Doctor> findByOnline() {
        return null;
    }

    @Override
    public List<Doctor> findBySpecializationName(String specName) {
        return null;
    }

    @Override
    public List<Doctor> findByWhereStudy(String whereStudy) {
        return null;
    }

    @Override
    public List<Client> getListMyClients(long doctorID) {
        return null;
    }

    @Override
    public WorkFlow getMyWorkFlow(GregorianCalendar currentDate, long doctorID) {
        return null;
    }

    @Override
    public MedicalCardClient getMedicalCard(long clientID) {
        return null;
    }

    @Override
    public MedicalCardClient createMedicalCard(MedicalCardDto dto) {
        return null;
    }

    @Override
    public void addNewRecordInMedicalCardClient(MedicalCardBodyDto dto, long medCardID) {

    }
}
