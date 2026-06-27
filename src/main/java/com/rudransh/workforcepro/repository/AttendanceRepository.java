package com.rudransh.workforcepro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rudransh.workforcepro.entity.Attendance;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {

}