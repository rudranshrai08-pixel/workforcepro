package com.rudransh.workforcepro.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rudransh.workforcepro.repository.AttendanceRepository;
import com.rudransh.workforcepro.repository.DepartmentRepository;
import com.rudransh.workforcepro.repository.EmployeeRepository;
import com.rudransh.workforcepro.repository.LeaveRepository;
import com.rudransh.workforcepro.repository.PayrollRepository;

@RestController
public class DashboardController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private LeaveRepository leaveRepository;

    @Autowired
    private AttendanceRepository attendanceRepository;

    @Autowired
    private PayrollRepository payrollRepository;

    @GetMapping("/api/dashboard")
    public Map<String, Long> getDashboardData() {

        Map<String, Long> dashboard = new HashMap<>();

        dashboard.put("Total Employees", employeeRepository.count());
        dashboard.put("Total Departments", departmentRepository.count());

        dashboard.put("Total Leaves", leaveRepository.count());
        dashboard.put("Pending Leaves", leaveRepository.countByStatus("PENDING"));
        dashboard.put("Approved Leaves", leaveRepository.countByStatus("APPROVED"));
        dashboard.put("Rejected Leaves", leaveRepository.countByStatus("REJECTED"));

        dashboard.put("Total Attendance", attendanceRepository.count());
        dashboard.put("Total Payroll", payrollRepository.count());

        return dashboard;
    }
}