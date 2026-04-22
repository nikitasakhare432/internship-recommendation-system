package com.app.service;

import com.app.model.Internship;
import com.app.repository.InternshipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InternshipService {

    @Autowired
    private InternshipRepository internshipRepository;

    public Internship addInternship(Internship internship) {
        return internshipRepository.save(internship);
    }

    public List<Internship> getAllInternships() {
        return internshipRepository.findAll();
    }

    public Internship getInternshipById(Long id) {
        return internshipRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Internship not found"));
    }

    public Internship updateInternship(Long id, Internship updatedInternship) {
        Internship internship = internshipRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Internship not found"));

        internship.setCompanyName(updatedInternship.getCompanyName());
        internship.setRole(updatedInternship.getRole());
        internship.setRequiredSkills(updatedInternship.getRequiredSkills());
        internship.setLocation(updatedInternship.getLocation());
        internship.setDomain(updatedInternship.getDomain());
        internship.setInternshipType(updatedInternship.getInternshipType());
        internship.setStipend(updatedInternship.getStipend());

        return internshipRepository.save(internship);
    }

    public String deleteInternship(Long id) {
        Internship internship = internshipRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Internship not found"));

        internshipRepository.delete(internship);
        return "Internship deleted successfully";
    }
}