package com.medclinic.repository.impl;

import com.medclinic.entity.Client;
import com.medclinic.hibernate.GenericDAOImpl;
import com.medclinic.repository.IClientRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;


@Repository
public class ClientRepository extends GenericDAOImpl implements IClientRepository {
    public ClientRepository() {
        this.setEntityClass(Client.class);
    }

    @Override
    public List findByFamily(String family) {
        CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
        CriteriaQuery criteria = builder.createQuery();
        Root<Client> root = criteria.from(Client.class);
        criteria.select(root).where(builder.like(root.get("familyName"), "%"+family+"%"));
        return this.getEntityManager().createQuery(criteria).getResultList();
    }

    @Override
    public Object findByPhoneNumber(String number) {
        CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
        CriteriaQuery criteria = builder.createQuery();
        Root<Client> root = criteria.from(Client.class);
        criteria.select(root).where(builder.equal(root.get("phoneNumber"), number));
        return this.getEntityManager().createQuery(criteria).getResultList();
    }

    //TODO Дописать потом уже уникальную критерию с выборкой данных их медкарты клиента.
    // Связывая медкарту клиента по id клиента.
    @Override
    public List findByBloodGroup(String group) {
        return null;
    }

    @Override
    public List findByFullName(String fullName) {
        CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
        CriteriaQuery criteria = builder.createQuery();
        Root<Client> root = criteria.from(Client.class);
        criteria.select(root).where(builder.equal(root.get("fullName"), fullName));
        return this.getEntityManager().createQuery(criteria).getResultList();
    }
}
