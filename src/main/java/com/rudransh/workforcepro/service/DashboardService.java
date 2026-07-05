package com.rudransh.workforcepro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rudransh.workforcepro.dto.DashboardResponseDto;
import com.rudransh.workforcepro.repository.EmployeeRepository;
import com.rudransh.workforcepro.repository.LeaveRepository;

@Service
public class DashboardService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private LeaveRepository leaveRepository;

    public DashboardResponseDto getDashboardData() {

        long totalEmployees = employeeRepository.count();
        long totalLeaves = leaveRepository.count();

        long pendingLeaves = leaveRepository.findAll()
                .stream()
                .filter(leave -> "PENDING".equalsIgnoreCase(leave.getStatus()))
                .count();

        long approvedLeaves = leaveRepository.findAll()
                .stream()
                .filter(leave -> "APPROVED".equalsIgnoreCase(leave.getStatus()))
                .count();

        long rejectedLeaves = leaveRepository.findAll()
                .stream()
                .filter(leave -> "REJECTED".equalsIgnoreCase(leave.getStatus()))
                .count();

        return new DashboardResponseDto(
                totalEmployees,
                totalLeaves,
                pendingLeaves,
                approvedLeaves,
                rejectedLeaves
        );
    }
}