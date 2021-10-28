package com.medclinic.repository;

import com.medclinic.hibernate.GenericDAO;
import java.util.List;

public interface UserRepository<T, ID> extends GenericDAO {
    T findByLogin(String login);
    T findByEmail(String email);
    List<T> findByStatus(String status);
}
