package com.rudransh.workforcepro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rudransh.workforcepro.entity.Recruitment;
import com.rudransh.workforcepro.repository.RecruitmentRepository;

@Service
public class RecruitmentService {

    @Autowired
    private RecruitmentRepository recruitmentRepository;

    public Recruitment saveRecruitment(Recruitment recruitment) {
        return recruitmentRepository.save(recruitment);
    }

    public List<Recruitment> getAllRecruitment() {
        return recruitmentRepository.findAll();
    }

    public Recruitment getRecruitmentById(Long id) {
        return recruitmentRepository.findById(id).orElse(null);
    }

    public Recruitment updateRecruitment(Long id, Recruitment updatedRecruitment) {

        Recruitment recruitment = recruitmentRepository.findById(id).orElse(null);

        if (recruitment != null) {
            recruitment.setCandidateName(updatedRecruitment.getCandidateName());
            recruitment.setJobPosition(updatedRecruitment.getJobPosition());
            recruitment.setInterviewDate(updatedRecruitment.getInterviewDate());
            recruitment.setInterviewStatus(updatedRecruitment.getInterviewStatus());
            recruitment.setSelectionStatus(updatedRecruitment.getSelectionStatus());

            return recruitmentRepository.save(recruitment);
        }

        return null;
    }

    public void deleteRecruitment(Long id) {
        recruitmentRepository.deleteById(id);
    }
}