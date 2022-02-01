package com.medclinic.repository;

import com.medclinic.config.hibernate.GenericDAO;
import java.util.List;

public interface IUserRepository<T> extends GenericDAO {
    T findByLogin(String login);
    T findByEmail(String email);
    List<T> findByStatus(String status);
}
