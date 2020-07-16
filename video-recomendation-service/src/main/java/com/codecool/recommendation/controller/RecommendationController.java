package com.codecool.recommendation.controller;

import com.codecool.recommendation.entity.Recommendation;
import com.codecool.recommendation.service.RecommendationManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/recommendation-service")
public class RecommendationController {

    @Autowired
    private RecommendationManager recommendationManager;

    @GetMapping("/find-by-id/{id}")
    public List<Recommendation> getAll(@PathVariable("id") Long id) {
        return recommendationManager.findByVideoId(id);
    }
}
