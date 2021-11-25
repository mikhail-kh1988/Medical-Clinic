package com.medclinic.repository.impl;

import com.medclinic.entity.Department;
import com.medclinic.config.hibernate.GenericDAOImpl;
import com.medclinic.repository.IDepartmentRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;


@Repository
public class DepartmentRepository extends GenericDAOImpl implements IDepartmentRepository {
    public DepartmentRepository() {
        this.setEntityClass(Department.class);
    }

    @Override
    public Object findByDepName(String name) {
        CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
        CriteriaQuery criteria = builder.createQuery();
        Root<Department> root = criteria.from(Department.class);
        criteria.select(root).where(builder.equal(root.get("departmentName"), name));
        return this.getEntityManager().createQuery(criteria).getSingleResult();
    }
}
