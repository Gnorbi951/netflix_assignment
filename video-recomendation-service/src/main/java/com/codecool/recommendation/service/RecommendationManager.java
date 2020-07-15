package com.codecool.recommendation.service;

import com.codecool.recommendation.entity.Recommendation;
import com.codecool.recommendation.repository.RecommendationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecommendationManager {

    @Autowired
    private RecommendationRepository recommendationRepository;

    public List<Recommendation> getAll() {
        return recommendationRepository.findAll();
    }

}
