package com.rudransh.workforcepro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rudransh.workforcepro.entity.Payroll;

public interface PayrollRepository extends JpaRepository<Payroll, Long> {

}