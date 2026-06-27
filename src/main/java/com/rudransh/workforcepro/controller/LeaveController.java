package com.rudransh.workforcepro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.rudransh.workforcepro.entity.Leave;
import com.rudransh.workforcepro.service.LeaveService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/leaves")
public class LeaveController {

    @Autowired
    private LeaveService leaveService;

    @PostMapping
    public Leave createLeave(@Valid @RequestBody Leave leave) {
        return leaveService.saveLeave(leave);
    }

    @GetMapping
    public List<Leave> getAllLeaves() {
        return leaveService.getAllLeaves();
    }

    @GetMapping("/{id}")
    public Leave getLeaveById(@PathVariable Long id) {
        return leaveService.getLeaveById(id);
    }

    @PutMapping("/{id}")
    public Leave updateLeave(@PathVariable Long id,
                             @Valid @RequestBody Leave leave) {
        return leaveService.updateLeave(id, leave);
    }

    @DeleteMapping("/{id}")
    public String deleteLeave(@PathVariable Long id) {
        leaveService.deleteLeave(id);
        return "Leave deleted successfully";
    }
}