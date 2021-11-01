package com.medclinic.repository.impl;

import com.medclinic.entity.Client;
import com.medclinic.hibernate.GenericDAOImpl;
import com.medclinic.repository.IClientRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class ClientRepository extends GenericDAOImpl implements IClientRepository {
    public ClientRepository() {
        this.setEntityClass(Client.class);
    }

    @Override
    public List findByFamily(String family) {
        return null;
    }

    @Override
    public Object findByPhoneNumber(String number) {
        return null;
    }

    @Override
    public List findByBloodGroup(String group) {
        return null;
    }

    @Override
    public List findByFullName(String fullName) {
        return null;
    }
}
