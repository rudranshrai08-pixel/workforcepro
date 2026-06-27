package com.rudransh.workforcepro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.rudransh.workforcepro.entity.Attendance;
import com.rudransh.workforcepro.service.AttendanceService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @PostMapping
    public Attendance createAttendance(@Valid @RequestBody Attendance attendance) {
        return attendanceService.saveAttendance(attendance);
    }

    @GetMapping
    public List<Attendance> getAllAttendance() {
        return attendanceService.getAllAttendance();
    }

    @GetMapping("/{id}")
    public Attendance getAttendanceById(@PathVariable Long id) {
        return attendanceService.getAttendanceById(id);
    }

    @PutMapping("/{id}")
    public Attendance updateAttendance(@PathVariable Long id,
                                       @Valid @RequestBody Attendance attendance) {
        return attendanceService.updateAttendance(id, attendance);
    }

    @DeleteMapping("/{id}")
    public String deleteAttendance(@PathVariable Long id) {
        attendanceService.deleteAttendance(id);
        return "Attendance deleted successfully";
    }
}