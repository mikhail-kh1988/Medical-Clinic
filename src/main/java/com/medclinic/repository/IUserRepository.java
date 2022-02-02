package com.medclinic.repository;

import com.medclinic.config.hibernate.GenericDAO;
import com.medclinic.entity.User;

import java.util.List;

public interface IUserRepository extends GenericDAO<User> {
    User findByLogin(String login);
    User findByEmail(String email);
    List<User> findByStatus(String status);
}
