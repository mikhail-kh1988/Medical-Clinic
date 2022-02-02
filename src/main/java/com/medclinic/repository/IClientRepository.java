package com.medclinic.repository;

import com.medclinic.config.hibernate.GenericDAO;
import com.medclinic.entity.Client;

import java.util.List;

public interface IClientRepository extends GenericDAO<Client> {
    List<Client> findByFamily(String family);
    Client findByPhoneNumber(String number);
    Client findByLogin(String login);
    List<Client> findByFullName(String fullName);
}
