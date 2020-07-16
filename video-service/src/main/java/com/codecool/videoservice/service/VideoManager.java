package com.codecool.videoservice.service;

import com.codecool.recommendation.entity.Recommendation;
import com.codecool.recommendation.service.RecommendationManager;
import com.codecool.videoservice.entity.Video;
import com.codecool.videoservice.repository.VideoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.java.Log;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

@Service
public class VideoManager {

    @Autowired
    VideoRepository videoRepository;



    public List<Video> retrieveAllVideos() {
        return videoRepository.findAll();
    }

    public HashMap<Video, List<Recommendation>> findVideoWithRecommendations(Long id) throws IOException {
        HashMap<Video, List<Recommendation>> result = new HashMap<>();

        Video foundVideo = videoRepository.findById(id).orElse(null);
        if (foundVideo == null) return null;

        ObjectMapper mapper = new ObjectMapper();
        List<Recommendation> recommendations = mapper.readValue(new URL("http://localhost:8081/recommendation-service/find-by-id/" + id),
                List.class);
        if (recommendations.size() == 0) recommendations = null;

        result.put(foundVideo, recommendations);

        return result;

    }
}
