package com.rudransh.workforcepro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rudransh.workforcepro.entity.Attendance;
import com.rudransh.workforcepro.repository.AttendanceRepository;

@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    public Attendance saveAttendance(Attendance attendance) {
        return attendanceRepository.save(attendance);
    }

    public List<Attendance> getAllAttendance() {
        return attendanceRepository.findAll();
    }

    public Attendance getAttendanceById(Long id) {
        return attendanceRepository.findById(id).orElse(null);
    }

    public Attendance updateAttendance(Long id, Attendance updatedAttendance) {

        Attendance attendance = attendanceRepository.findById(id).orElse(null);

        if (attendance != null) {
            attendance.setEmployeeName(updatedAttendance.getEmployeeName());
            attendance.setDate(updatedAttendance.getDate());
            attendance.setCheckIn(updatedAttendance.getCheckIn());
            attendance.setCheckOut(updatedAttendance.getCheckOut());
            attendance.setStatus(updatedAttendance.getStatus());

            return attendanceRepository.save(attendance);
        }

        return null;
    }

    public void deleteAttendance(Long id) {
        attendanceRepository.deleteById(id);
    }
}