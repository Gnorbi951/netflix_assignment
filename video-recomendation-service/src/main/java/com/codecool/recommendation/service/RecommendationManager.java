package com.codecool.recommendation.service;

import com.codecool.recommendation.entity.Recommendation;
import com.codecool.recommendation.repository.RecommendationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RecommendationManager {

    @Autowired
    private RecommendationRepository recommendationRepository;

    public List<Recommendation> getAll() {
        return recommendationRepository.findAll();
    }

    public List<Recommendation> findByVideoId(Long id) {

        return recommendationRepository.findEveryElementByVideoId(id);

    }

    public boolean saveRecommendation(Recommendation recommendation) {
        try {
            Recommendation build = Recommendation.builder()
                    .rating(recommendation.getRating())
                    .comment(recommendation.getComment())
                    .videoId(recommendation.getVideoId())
                    .build();
            recommendationRepository.save(build);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
