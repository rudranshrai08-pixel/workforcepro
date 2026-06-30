package com.rudransh.workforcepro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rudransh.workforcepro.entity.Performance;

public interface PerformanceRepository extends JpaRepository<Performance, Long> {

}