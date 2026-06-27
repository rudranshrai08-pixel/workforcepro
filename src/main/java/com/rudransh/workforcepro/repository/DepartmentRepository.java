package com.rudransh.workforcepro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rudransh.workforcepro.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

}