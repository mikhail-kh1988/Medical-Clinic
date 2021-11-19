package com.medclinic.service.impl;

import com.medclinic.entity.Department;
import com.medclinic.repository.IDepartmentRepository;
import com.medclinic.service.IDepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class DepartmentService implements IDepartmentService {

    @Autowired
    private IDepartmentRepository departmentRepository;

    @Override
    public Department findDepartmentByName(String name) {
        return (Department) departmentRepository.findByDepName(name);
    }

    @Override
    public Department findDepartmentByID(long id) {
        return (Department) departmentRepository.findByID(id);
    }

    @Transactional
    @Override
    public Department createNewDepartment(String nameDepth) {
        Department department = new Department();
        department.setDepartmentName(nameDepth);
        departmentRepository.save(department);
        log.info("Create department by name: "+department.getDepartmentName()+".");
        return department;
    }

    @Transactional
    @Override
    public void updateDepartment(String department, String newNameDep) {
        Department currentDepth = (Department) departmentRepository.findByDepName(department);
        currentDepth.setDepartmentName(newNameDep);
        departmentRepository.save(currentDepth);
        log.info("Update department name. Old name:"+department+", new name:"+newNameDep);
    }

    @Transactional
    @Override
    public void deleteDepartment(String department) {
        Department currentDepth = (Department) departmentRepository.findByDepName(department);
        departmentRepository.delete(currentDepth);
        log.info("Delete department by name:"+department);
    }
}
