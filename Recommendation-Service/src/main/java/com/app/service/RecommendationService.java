package com.app.service;

import com.app.dto.InternshipDto;
import com.app.dto.RecommendationResponse;
import com.app.dto.StudentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class RecommendationService {

    @Autowired
    private RestTemplate restTemplate;

    public List<RecommendationResponse> getRecommendations(Long studentId) {
        String studentServiceUrl = "http://localhost:8081/students/" + studentId;
        String internshipServiceUrl = "http://localhost:8082/internships";

        StudentDto student = restTemplate.getForObject(studentServiceUrl, StudentDto.class);   // u are calling an external api(like get function) // storing result in variable 
        // getforObject=it send get reuest to api and send response
        //studentDto.student=it send response in that studentDto response

        ResponseEntity<List<InternshipDto>> response = restTemplate.exchange(
                internshipServiceUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<InternshipDto>>() {}
        );

        List<InternshipDto> internships = response.getBody();

        Set<String> studentSkills = convertToSet(student.getSkills());

        List<RecommendationResponse> recommendations = new ArrayList<>();

        for (InternshipDto internship : internships) {
            int score = 0;
            Set<String> internshipSkills = convertToSet(internship.getRequiredSkills());

            for (String skill : studentSkills) {
                if (internshipSkills.contains(skill)) {
                    score += 10;
                }
            }

            if (student.getPreferredLocation() != null &&
                    student.getPreferredLocation().equalsIgnoreCase(internship.getLocation())) {
                score += 5;
            }

            if (student.getPreferredDomain() != null &&
                    student.getPreferredDomain().equalsIgnoreCase(internship.getDomain())) {
                score += 5;
            }

            if (student.getInternshipType() != null &&
                    student.getInternshipType().equalsIgnoreCase(internship.getInternshipType())) {
                score += 5;
            }

            recommendations.add(new RecommendationResponse(internship, score));
        }

        return recommendations.stream()
                .sorted((a, b) -> Integer.compare(b.getMatchScore(), a.getMatchScore()))
                .collect(Collectors.toList());
    }

    private Set<String> convertToSet(String value) {
        if (value == null || value.isEmpty()) {
            return new HashSet<>();
        }

        return Arrays.stream(value.toLowerCase().split(","))
                .map(String::trim)
                .collect(Collectors.toSet());
    }
}