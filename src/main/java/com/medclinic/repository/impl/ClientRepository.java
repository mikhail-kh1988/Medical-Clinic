package com.medclinic.repository.impl;

import com.medclinic.entity.Bill;
import com.medclinic.entity.Client;
import com.medclinic.config.hibernate.GenericDAOImpl;
import com.medclinic.repository.IClientRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;


@Repository
public class ClientRepository extends GenericDAOImpl<Client> implements IClientRepository {
    public ClientRepository() {
        this.setEntityClass(Client.class);
    }

    @Override
    public List<Client> findByFamily(String family) {
        CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Client> criteria = builder.createQuery(Client.class);
        Root<Client> root = criteria.from(Client.class);
        criteria.select(root).where(builder.like(root.get("familyName"), "%"+family+"%"));
        return this.getEntityManager().createQuery(criteria).getResultList();
    }

    @Override
    public Client findByPhoneNumber(String number) {
        CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Client> criteria = builder.createQuery(Client.class);
        Root<Client> root = criteria.from(Client.class);
        criteria.select(root).where(builder.equal(root.get("phoneNumber"), number));
        return this.getEntityManager().createQuery(criteria).getSingleResult();
    }

    @Override
    public Client findByLogin(String login) {
        CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Client> criteria = builder.createQuery(Client.class);
        Root<Client> root = criteria.from(Client.class);
        criteria.select(root).where(builder.equal(root.get("login"), login));
        return this.getEntityManager().createQuery(criteria).getSingleResult();
    }


    @Override
    public List<Client> findByFullName(String fullName) {
        CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Client> criteria = builder.createQuery(Client.class);
        Root<Client> root = criteria.from(Client.class);
        criteria.select(root).where(builder.equal(root.get("fullName"), fullName));
        return this.getEntityManager().createQuery(criteria).getResultList();
    }
}
