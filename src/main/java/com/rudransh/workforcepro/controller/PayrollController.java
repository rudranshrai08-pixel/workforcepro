package com.rudransh.workforcepro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.rudransh.workforcepro.entity.Payroll;
import com.rudransh.workforcepro.service.PayrollService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/payroll")
public class PayrollController {

    @Autowired
    private PayrollService payrollService;

    @PostMapping
    public Payroll createPayroll(@Valid @RequestBody Payroll payroll) {
        return payrollService.savePayroll(payroll);
    }

    @GetMapping
    public List<Payroll> getAllPayroll() {
        return payrollService.getAllPayroll();
    }

    @GetMapping("/{id}")
    public Payroll getPayrollById(@PathVariable Long id) {
        return payrollService.getPayrollById(id);
    }

    @PutMapping("/{id}")
    public Payroll updatePayroll(@PathVariable Long id,
                                 @Valid @RequestBody Payroll payroll) {
        return payrollService.updatePayroll(id, payroll);
    }

    @DeleteMapping("/{id}")
    public String deletePayroll(@PathVariable Long id) {
        payrollService.deletePayroll(id);
        return "Payroll deleted successfully";
    }
}