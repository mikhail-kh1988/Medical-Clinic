package com.medclinic.repository.impl;

import com.medclinic.entity.Department;
import com.medclinic.hibernate.GenericDAOImpl;
import com.medclinic.repository.IDepartmentRepository;
import org.springframework.stereotype.Repository;


@Repository
public class DepartmentRepository extends GenericDAOImpl implements IDepartmentRepository {
    public DepartmentRepository() {
        this.setEntityClass(Department.class);
    }

    @Override
    public Object findByDepName(String name) {
        return null;
    }
}
