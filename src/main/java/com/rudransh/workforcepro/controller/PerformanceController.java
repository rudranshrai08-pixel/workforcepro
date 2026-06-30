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

import com.rudransh.workforcepro.entity.Performance;
import com.rudransh.workforcepro.service.PerformanceService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/performance")
public class PerformanceController {

    @Autowired
    private PerformanceService performanceService;

    @PostMapping
    public Performance createPerformance(@Valid @RequestBody Performance performance) {
        return performanceService.savePerformance(performance);
    }

    @GetMapping
    public List<Performance> getAllPerformance() {
        return performanceService.getAllPerformance();
    }

    @GetMapping("/{id}")
    public Performance getPerformanceById(@PathVariable Long id) {
        return performanceService.getPerformanceById(id);
    }

    @PutMapping("/{id}")
    public Performance updatePerformance(@PathVariable Long id,
                                         @Valid @RequestBody Performance performance) {
        return performanceService.updatePerformance(id, performance);
    }

    @DeleteMapping("/{id}")
    public String deletePerformance(@PathVariable Long id) {
        performanceService.deletePerformance(id);
        return "Performance record deleted successfully";
    }
}