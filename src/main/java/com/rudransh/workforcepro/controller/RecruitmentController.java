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

import com.rudransh.workforcepro.entity.Recruitment;
import com.rudransh.workforcepro.service.RecruitmentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/recruitment")
public class RecruitmentController {

    @Autowired
    private RecruitmentService recruitmentService;

    @PostMapping
    public Recruitment createRecruitment(@Valid @RequestBody Recruitment recruitment) {
        return recruitmentService.saveRecruitment(recruitment);
    }

    @GetMapping
    public List<Recruitment> getAllRecruitment() {
        return recruitmentService.getAllRecruitment();
    }

    @GetMapping("/{id}")
    public Recruitment getRecruitmentById(@PathVariable Long id) {
        return recruitmentService.getRecruitmentById(id);
    }

    @PutMapping("/{id}")
    public Recruitment updateRecruitment(@PathVariable Long id,
                                         @Valid @RequestBody Recruitment recruitment) {
        return recruitmentService.updateRecruitment(id, recruitment);
    }

    @DeleteMapping("/{id}")
    public String deleteRecruitment(@PathVariable Long id) {
        recruitmentService.deleteRecruitment(id);
        return "Recruitment record deleted successfully";
    }
}