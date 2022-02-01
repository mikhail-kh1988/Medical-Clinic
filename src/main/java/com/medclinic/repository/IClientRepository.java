package com.medclinic.repository;

import com.medclinic.config.hibernate.GenericDAO;
import java.util.List;

public interface IClientRepository<T> extends GenericDAO {
    List<T> findByFamily(String family);
    T findByPhoneNumber(String number);
    T findByLogin(String login);
    List<T> findByFullName(String fullName);
}
