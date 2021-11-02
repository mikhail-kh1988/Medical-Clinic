package com.medclinic.repository.impl;

import com.medclinic.entity.User;
import com.medclinic.hibernate.GenericDAOImpl;
import com.medclinic.repository.IUserRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class UserRepository extends GenericDAOImpl implements IUserRepository {
    public UserRepository() {
        this.setEntityClass(User.class);
    }

    @Override
    public Object findByLogin(String login) {
        CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
        CriteriaQuery criteria = builder.createQuery();
        Root<User> root = criteria.from(User.class);
        criteria.select(root).where(builder.equal(root.get("login"), login));
        return this.getEntityManager().createQuery(criteria).getSingleResult();
    }

    @Override
    public Object findByEmail(String email) {
        CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
        CriteriaQuery criteria = builder.createQuery();
        Root<User> root = criteria.from(User.class);
        criteria.select(root).where(builder.equal(root.get("email"), email));
        return this.getEntityManager().createQuery(criteria).getSingleResult();
    }

    @Override
    public List findByStatus(String status) {
        CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
        CriteriaQuery criteria = builder.createQuery();
        Root<User> root = criteria.from(User.class);
        criteria.select(root).where(builder.equal(root.get("status"), status));
        return this.getEntityManager().createQuery(criteria).getResultList();
    }
}
