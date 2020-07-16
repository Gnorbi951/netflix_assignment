package com.codecool.videoservice.controller;

import com.codecool.recommendation.entity.Recommendation;
import com.codecool.videoservice.entity.Video;
import com.codecool.videoservice.service.VideoManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "/video-controller")
public class VideoController {

    @Autowired
    VideoManager videoManager;

    @GetMapping("/all")
    public List<Video> getAllVideos() {
        return videoManager.retrieveAllVideos();
    }

    @GetMapping("/video-with-recommendations/{id}")
    public List<Recommendation> getVideoWithRecommendations(@PathVariable("id") Long id) throws IOException {
        return videoManager.findVideoWithRecommendations(id);
    }

    @GetMapping("/video/{id}")
    public Video getVideo(@PathVariable("id") Long id) {
        return videoManager.findVideoById(id);
    }

    @PostMapping("/add-recommendation")
    public String addRecommendation(@ModelAttribute Recommendation recommendation) {
        System.out.println(recommendation.toString());
        return "lol";
    }
}
