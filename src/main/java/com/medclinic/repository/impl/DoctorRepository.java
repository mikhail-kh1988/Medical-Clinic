package com.medclinic.repository.impl;

import com.medclinic.entity.Doctor;
import com.medclinic.config.hibernate.GenericDAOImpl;
import com.medclinic.repository.IDoctorRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.print.Doc;
import java.util.List;

@Repository
public class DoctorRepository extends GenericDAOImpl<Doctor> implements IDoctorRepository {
    public DoctorRepository() {
        this.setEntityClass(Doctor.class);
    }

    @Override
    public List<Doctor> findByFullName(String fullName) {
        CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Doctor> criteria = builder.createQuery(Doctor.class);
        Root<Doctor> root = criteria.from(Doctor.class);
        criteria.select(root).where(builder.equal(root.get("fullName"), fullName));
        return this.getEntityManager().createQuery(criteria).getResultList();
    }

    @Override
    public Doctor findByLogin(String login) {
        CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Doctor> criteria = builder.createQuery(Doctor.class);
        Root<Doctor> root = criteria.from(Doctor.class);
        criteria.select(root).where(builder.equal(root.get("login"), login));
        return this.getEntityManager().createQuery(criteria).getSingleResult();
    }

    @Override
    public List<Doctor> findByFamily(String family) {
        CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Doctor> criteria = builder.createQuery(Doctor.class);
        Root<Doctor> root = criteria.from(Doctor.class);
        criteria.select(root).where(builder.equal(root.get("family"), family));
        return this.getEntityManager().createQuery(criteria).getResultList();
    }

    @Override
    public Doctor findByEmail(String email) {
        CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Doctor> criteria = builder.createQuery(Doctor.class);
        Root<Doctor> root = criteria.from(Doctor.class);
        criteria.select(root).where(builder.equal(root.get("email"), email));
        return this.getEntityManager().createQuery(criteria).getSingleResult();
    }

    @Override
    public List<Doctor> findByOnline() {
        CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Doctor> criteria = builder.createQuery(Doctor.class);
        Root<Doctor> root = criteria.from(Doctor.class);
        criteria.select(root).where(builder.equal(root.get("online"), true));
        return this.getEntityManager().createQuery(criteria).getResultList();
    }

    @Override
    public List<Doctor> findBySpecializationName(String secName) {
        CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Doctor> criteria = builder.createQuery(Doctor.class);
        Root<Doctor> root = criteria.from(Doctor.class);
        criteria.select(root).where(builder.equal(root.get("specializationName"), secName));
        return this.getEntityManager().createQuery(criteria).getResultList();
    }

    @Override
    public List<Doctor> findByWhereStudy(String whereStudy) {
        CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Doctor> criteria = builder.createQuery(Doctor.class);
        Root<Doctor> root = criteria.from(Doctor.class);
        criteria.select(root).where(builder.equal(root.get("whereStudy"), whereStudy));
        return this.getEntityManager().createQuery(criteria).getResultList();
    }
}
