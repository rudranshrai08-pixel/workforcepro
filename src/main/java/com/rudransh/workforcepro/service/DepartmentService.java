package com.rudransh.workforcepro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rudransh.workforcepro.entity.Department;
import com.rudransh.workforcepro.repository.DepartmentRepository;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public Department getDepartmentById(Long id) {
        return departmentRepository.findById(id).orElse(null);
    }

    public Department updateDepartment(Long id, Department updatedDepartment) {

        Department department = departmentRepository.findById(id).orElse(null);

        if (department != null) {
            department.setName(updatedDepartment.getName());
            department.setDescription(updatedDepartment.getDescription());

            return departmentRepository.save(department);
        }

        return null;
    }

    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }
}