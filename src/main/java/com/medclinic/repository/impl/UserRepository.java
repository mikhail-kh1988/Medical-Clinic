package com.medclinic.repository.impl;

import com.medclinic.entity.User;
import com.medclinic.hibernate.GenericDAOImpl;
import com.medclinic.repository.IUserRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository extends GenericDAOImpl implements IUserRepository {
    public UserRepository() {
        this.setEntityClass(User.class);
    }

    @Override
    public Object findByLogin(String login) {
        return null;
    }

    @Override
    public Object findByEmail(String email) {
        return null;
    }

    @Override
    public List findByStatus(String status) {
        return null;
    }
}
