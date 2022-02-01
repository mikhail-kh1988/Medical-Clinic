package com.medclinic.repository;

import com.medclinic.config.hibernate.GenericDAO;

public interface IDepartmentRepository<T> extends GenericDAO {

    T findByDepName(String name);

}
