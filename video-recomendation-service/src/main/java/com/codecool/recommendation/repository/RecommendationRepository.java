package com.codecool.recommendation.repository;

import com.codecool.recommendation.entity.Recommendation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RecommendationRepository extends JpaRepository<Recommendation, Long> {

    @Query("SELECT recommendation FROM Recommendation recommendation WHERE recommendation.videoId = :id")
    List<Recommendation> findEveryElementByVideoId(@Param("id")Long id);
}
