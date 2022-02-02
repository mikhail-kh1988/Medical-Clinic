package com.medclinic.repository;

import com.medclinic.config.hibernate.GenericDAO;
import com.medclinic.entity.Doctor;

import java.util.List;

public interface IDoctorRepository extends GenericDAO<Doctor> {
    List<Doctor> findByFullName(String fullName);
    Doctor findByLogin(String login);
    List<Doctor> findByFamily(String family);
    Doctor findByEmail(String email);
    List<Doctor> findByOnline();
    List<Doctor> findBySpecializationName(String secName);
    List<Doctor> findByWhereStudy(String whereStudy);
}
