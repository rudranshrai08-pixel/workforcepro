package com.rudransh.workforcepro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rudransh.workforcepro.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}