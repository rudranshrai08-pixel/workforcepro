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

    // Apply Leave
    public Leave saveLeave(Leave leave) {
        return leaveRepository.save(leave);
    }

    // View All Leave Requests
    public List<Leave> getAllLeaves() {
        return leaveRepository.findAll();
    }

    // Get Leave By ID
    public Leave getLeaveById(Long id) {
        return leaveRepository.findById(id).orElse(null);
    }

    // Update Leave
    public Leave updateLeave(Long id, Leave updatedLeave) {

        Leave leave = leaveRepository.findById(id).orElse(null);

        if (leave != null) {
            leave.setEmployeeName(updatedLeave.getEmployeeName());
            leave.setEmail(updatedLeave.getEmail());
            leave.setLeaveType(updatedLeave.getLeaveType());
            leave.setStartDate(updatedLeave.getStartDate());
            leave.setEndDate(updatedLeave.getEndDate());
            leave.setReason(updatedLeave.getReason());
            leave.setStatus(updatedLeave.getStatus());

            return leaveRepository.save(leave);
        }

        return null;
    }

    // Delete Leave
    public void deleteLeave(Long id) {
        leaveRepository.deleteById(id);
    }

    // Approve Leave
    public Leave approveLeave(Long id) {

        Leave leave = leaveRepository.findById(id).orElse(null);

        if (leave != null) {
            leave.setStatus("APPROVED");
            return leaveRepository.save(leave);
        }

        return null;
    }

    // Reject Leave
    public Leave rejectLeave(Long id) {

        Leave leave = leaveRepository.findById(id).orElse(null);

        if (leave != null) {
            leave.setStatus("REJECTED");
            return leaveRepository.save(leave);
        }

        return null;
    }
}