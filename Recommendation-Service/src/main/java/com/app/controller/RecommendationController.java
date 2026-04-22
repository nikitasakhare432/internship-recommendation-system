package com.app.controller;

import com.app.dto.RecommendationResponse;
import com.app.service.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recommendations")
public class RecommendationController {

    @Autowired
    private RecommendationService recommendationService;

    @GetMapping("/{studentId}")
    public List<RecommendationResponse> getRecommendations(@PathVariable Long studentId) {
        return recommendationService.getRecommendations(studentId);
    }
}