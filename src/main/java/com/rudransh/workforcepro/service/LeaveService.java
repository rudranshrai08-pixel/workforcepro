package com.rudransh.workforcepro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rudransh.workforcepro.entity.Leave;
import com.rudransh.workforcepro.repository.LeaveRepository;

@Service
public class LeaveService {

    @Autowired
    private LeaveRepository leaveRepository;

    public Leave saveLeave(Leave leave) {
        return leaveRepository.save(leave);
    }

    public List<Leave> getAllLeaves() {
        return leaveRepository.findAll();
    }

    public Leave getLeaveById(Long id) {
        return leaveRepository.findById(id).orElse(null);
    }

    public Leave updateLeave(Long id, Leave updatedLeave) {

        Leave leave = leaveRepository.findById(id).orElse(null);

        if (leave != null) {
            leave.setEmployeeName(updatedLeave.getEmployeeName());
            leave.setLeaveType(updatedLeave.getLeaveType());
            leave.setStartDate(updatedLeave.getStartDate());
            leave.setEndDate(updatedLeave.getEndDate());
            leave.setReason(updatedLeave.getReason());
            leave.setStatus(updatedLeave.getStatus());

            return leaveRepository.save(leave);
        }

        return null;
    }

    public void deleteLeave(Long id) {
        leaveRepository.deleteById(id);
    }
}