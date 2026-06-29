package com.rudransh.workforcepro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rudransh.workforcepro.entity.Payroll;
import com.rudransh.workforcepro.repository.PayrollRepository;

@Service
public class PayrollService {

    @Autowired
    private PayrollRepository payrollRepository;

    public Payroll savePayroll(Payroll payroll) {
        return payrollRepository.save(payroll);
    }

    public List<Payroll> getAllPayroll() {
        return payrollRepository.findAll();
    }

    public Payroll getPayrollById(Long id) {
        return payrollRepository.findById(id).orElse(null);
    }

    public Payroll updatePayroll(Long id, Payroll updatedPayroll) {

        Payroll payroll = payrollRepository.findById(id).orElse(null);

        if (payroll != null) {
            payroll.setEmployeeName(updatedPayroll.getEmployeeName());
            payroll.setBasicSalary(updatedPayroll.getBasicSalary());
            payroll.setBonus(updatedPayroll.getBonus());
            payroll.setDeductions(updatedPayroll.getDeductions());
            payroll.setNetSalary(updatedPayroll.getNetSalary());
            payroll.setPayDate(updatedPayroll.getPayDate());

            return payrollRepository.save(payroll);
        }

        return null;
    }

    public void deletePayroll(Long id) {
        payrollRepository.deleteById(id);
    }
}