package com.medclinic.repository;

import com.medclinic.hibernate.GenericDAO;
import java.util.List;

public interface IDoctorRepository<T, ID> extends GenericDAO {
    List<T> findByFullName(String fullName);
    T findByLogin(String login);
    List<T> findByFamily(String family);
    T findByEmail(String email);
    List<T> findByOnline();
    List<T> findBySpecializationName(String secName);
    List<T> findByWhereStudy(String whereStudy);
}
