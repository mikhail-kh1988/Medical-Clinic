package com.medclinic.service.impl;

import com.medclinic.entity.Department;
import com.medclinic.repository.IDepartmentRepository;
import com.medclinic.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class DepartmentService implements IDepartmentService {

    @Autowired
    private IDepartmentRepository departmentRepository;

    @Transactional
    @Override
    public Department createNewDepartment(String nameDepth) {
        Department department = new Department();
        department.setDepartmentName(nameDepth);
        departmentRepository.save(department);
        return department;
    }

    @Transactional
    @Override
    public void updateDepartment(String department, String newNameDep) {
        Department currentDepth = (Department) departmentRepository.findByDepName(department);
        currentDepth.setDepartmentName(newNameDep);
        departmentRepository.save(currentDepth);
    }

    @Transactional
    @Override
    public void deleteDepartment(String department) {
        Department currentDepth = (Department) departmentRepository.findByDepName(department);
        departmentRepository.delete(currentDepth);
    }
}
