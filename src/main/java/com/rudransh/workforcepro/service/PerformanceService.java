package com.rudransh.workforcepro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rudransh.workforcepro.entity.Performance;
import com.rudransh.workforcepro.repository.PerformanceRepository;

@Service
public class PerformanceService {

    @Autowired
    private PerformanceRepository performanceRepository;

    public Performance savePerformance(Performance performance) {
        return performanceRepository.save(performance);
    }

    public List<Performance> getAllPerformance() {
        return performanceRepository.findAll();
    }

    public Performance getPerformanceById(Long id) {
        return performanceRepository.findById(id).orElse(null);
    }

    public Performance updatePerformance(Long id, Performance updatedPerformance) {

        Performance performance = performanceRepository.findById(id).orElse(null);

        if (performance != null) {
            performance.setEmployeeName(updatedPerformance.getEmployeeName());
            performance.setRating(updatedPerformance.getRating());
            performance.setFeedback(updatedPerformance.getFeedback());
            performance.setReviewDate(updatedPerformance.getReviewDate());

            return performanceRepository.save(performance);
        }

        return null;
    }

    public void deletePerformance(Long id) {
        performanceRepository.deleteById(id);
    }
}