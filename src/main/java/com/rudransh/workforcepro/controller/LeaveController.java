package com.rudransh.workforcepro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rudransh.workforcepro.entity.Leave;
import com.rudransh.workforcepro.service.LeaveService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/leaves")
public class LeaveController {

    @Autowired
    private LeaveService leaveService;

    // Employee applies for leave
    @PostMapping
    public Leave createLeave(@Valid @RequestBody Leave leave) {
        return leaveService.saveLeave(leave);
    }

    // View all leave requests
    @GetMapping
    public List<Leave> getAllLeaves() {
        return leaveService.getAllLeaves();
    }

    // View leave by ID
    @GetMapping("/{id}")
    public Leave getLeaveById(@PathVariable Long id) {
        return leaveService.getLeaveById(id);
    }

    // Update leave
    @PutMapping("/{id}")
    public Leave updateLeave(@PathVariable Long id,
                             @Valid @RequestBody Leave leave) {
        return leaveService.updateLeave(id, leave);
    }

    // Delete leave
    @DeleteMapping("/{id}")
    public String deleteLeave(@PathVariable Long id) {
        leaveService.deleteLeave(id);
        return "Leave deleted successfully";
    }

    // Approve leave (ADMIN)
    @PutMapping("/{id}/approve")
    public Leave approveLeave(@PathVariable Long id) {
        return leaveService.approveLeave(id);
    }

    // Reject leave (ADMIN)
    @PutMapping("/{id}/reject")
    public Leave rejectLeave(@PathVariable Long id) {
        return leaveService.rejectLeave(id);
    }
}