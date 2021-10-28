package com.medclinic.repository.impl;

import com.medclinic.hibernate.GenericDAOImpl;
import com.medclinic.repository.IDoctorRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DoctorRepository extends GenericDAOImpl implements IDoctorRepository {
    public DoctorRepository() {
        this.setEntityClass(this.getClass());
    }

    @Override
    public List findByFullName(String fullName) {
        return null;
    }

    @Override
    public Object findByLogin(String login) {
        return null;
    }

    @Override
    public List findByFamily(String family) {
        return null;
    }

    @Override
    public Object findByEmail(String email) {
        return null;
    }

    @Override
    public List findByOnline() {
        return null;
    }

    @Override
    public List findBySpecializationName(String secName) {
        return null;
    }

    @Override
    public List findByWhereStudy(String whereStudy) {
        return null;
    }
}
