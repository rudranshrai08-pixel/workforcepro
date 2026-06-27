package com.rudransh.workforcepro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rudransh.workforcepro.entity.Leave;

public interface LeaveRepository extends JpaRepository<Leave, Long> {

}